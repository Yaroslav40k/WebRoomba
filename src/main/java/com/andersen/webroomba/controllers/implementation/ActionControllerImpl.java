package com.andersen.webroomba.controllers.implementation;

import com.andersen.webroomba.controllers.ActionController;
import com.andersen.webroomba.entity.inner.GridCleaningResult;
import com.andersen.webroomba.entity.inner.GridConfiguration;
import com.andersen.webroomba.entity.implementation.InputEntity;
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
public class ActionControllerImpl implements ActionController {

    private final InputService inputService;
    private final OutputService outputService;
    private final ConfigurationValidator configurationValidator;
    private final GridCreatorService gridCreatorService;
    private final HooverCreatorService hooverCreator;
    private final RoomCleanerService roomCleanerService;

    public ActionControllerImpl(final InputService inputService,
                                final OutputService outputService,
                                final ConfigurationValidator configurationValidator,
                                final GridCreatorService roomGridCreatorService,
                                final HooverCreatorService roboticHooverCreatorService,
                                final RoomCleanerService roomCleanerService) {
        this.inputService = inputService;
        this.outputService = outputService;
        this.configurationValidator = configurationValidator;
        this.gridCreatorService = roomGridCreatorService;
        this.hooverCreator = roboticHooverCreatorService;
        this.roomCleanerService = roomCleanerService;
    }

    @Override
    @PostMapping("/run")
    public ResponseEntity<GridCleaningResult> run(final @RequestBody GridConfiguration configuration) {
        InputEntity input = inputService.saveInput(configuration);
        configurationValidator.validate(configuration);
        RoomGrid grid = gridCreatorService.createGrid(configuration);
        Hoover hoover = hooverCreator.createHoover(grid, configuration);
        GridCleaningResult result = roomCleanerService.cleanRoom(hoover);
        outputService.saveOutput(input, result);
        return ResponseEntity.ok(result);
    }


}
