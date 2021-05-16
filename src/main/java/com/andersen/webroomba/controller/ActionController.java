package com.andersen.webroomba.controller;

import com.andersen.webroomba.entity.GridCleaningResult;
import com.andersen.webroomba.entity.GridConfiguration;
import com.andersen.webroomba.entity.Input;
import com.andersen.webroomba.model.Hoover;
import com.andersen.webroomba.model.implementation.RoomGrid;
import com.andersen.webroomba.service.*;
import com.andersen.webroomba.validator.implementation.ConfigurationValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * WebRoomba main controller. Typical, REST compatible.
 * Provides access to 'run' method.
 *
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */

@RestController
@RequestMapping(value = "/api/action")
public class ActionController {

    private final InputService inputService;
    private final OutputService outputService;
    private final ConfigurationValidator configurationValidator;
    private final GridCreatorService gridCreatorService;
    private final HooverCreatorService hooverCreator;
    private final RoomCleanerService roomCleanerService;

    public ActionController(InputService inputService,
                            OutputService outputService,
                            ConfigurationValidator configurationValidator,
                            GridCreatorService roomGridCreatorService,
                            HooverCreatorService roboticHooverCreatorService,
                            RoomCleanerService roomCleanerService) {
        this.inputService = inputService;
        this.outputService = outputService;
        this.configurationValidator = configurationValidator;
        this.gridCreatorService = roomGridCreatorService;
        this.hooverCreator = roboticHooverCreatorService;
        this.roomCleanerService = roomCleanerService;
    }

    @PostMapping("/run")
    public ResponseEntity<GridCleaningResult> run(@RequestBody GridConfiguration configuration) {
        Input input = inputService.saveInput(configuration);
        configurationValidator.validate(configuration);
        RoomGrid grid = gridCreatorService.createGrid(configuration);
        Hoover hoover = hooverCreator.createHoover(grid, configuration);
        GridCleaningResult result = roomCleanerService.cleanRoom(hoover);
        outputService.saveOutput(input, result);
        return ResponseEntity.ok(result);
    }


}
