package com.andersen.webroomba.service.implemantation;

import com.andersen.webroomba.entity.inner.GridConfiguration;
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

    public RoboticHooverCreatorService(final LidarCreatorService lidarCreatorService) {
        this.lidarCreatorService = lidarCreatorService;
    }

    @Override
    public Hoover createHoover(final RoomGrid grid, final GridConfiguration configuration) {
        Hoover roboticHoover = new RoboticHoover();
        roboticHoover.setGrid(grid);
        roboticHoover.setInstructions(configuration.getInstructions());
        roboticHoover.setLidar(lidarCreatorService.createLidar(configuration.getRoomSize()));
        return roboticHoover;
    }


}
