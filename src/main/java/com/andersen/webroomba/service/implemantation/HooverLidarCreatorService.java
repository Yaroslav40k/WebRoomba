package com.andersen.webroomba.service.implemantation;

import com.andersen.webroomba.model.Lidar;
import com.andersen.webroomba.model.implementation.HooverLidar;
import com.andersen.webroomba.service.LidarCreatorService;
import org.springframework.stereotype.Service;

/**
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
@Service
public class HooverLidarCreatorService implements LidarCreatorService {

    @Override
    public Lidar createLidar(int[] roomSize) {
        Lidar lidar = new HooverLidar();
        lidar.setMaxXCoordinate(roomSize[0]);
        lidar.setMaxYCoordinate(roomSize[0]);
        return lidar;
    }


}
