package com.andersen.webroomba.service.implemantation;

import com.andersen.webroomba.entity.GridConfiguration;
import com.andersen.webroomba.model.Hoover;
import com.andersen.webroomba.model.implementation.RoomGrid;
import com.andersen.webroomba.model.implementation.RoboticHoover;
import com.andersen.webroomba.service.HooverCreatorService;
import com.andersen.webroomba.service.LidarCreatorService;
import org.springframework.stereotype.Service;

/**
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
@Service
public class RoboticHooverCreatorService implements HooverCreatorService {

    private final LidarCreatorService lidarCreatorService;

    public RoboticHooverCreatorService(LidarCreatorService lidarCreatorService) {
        this.lidarCreatorService = lidarCreatorService;
    }

    @Override
    public Hoover createHoover(RoomGrid grid, GridConfiguration configuration) {
        Hoover roboticHoover = new RoboticHoover();
        roboticHoover.setGrid(grid);
        roboticHoover.setInstructions(configuration.getInstructions());
        roboticHoover.setLidar(lidarCreatorService.createLidar(configuration.getRoomSize()));
        return roboticHoover;
    }


}
