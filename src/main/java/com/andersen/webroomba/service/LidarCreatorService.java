package com.andersen.webroomba.service;

import com.andersen.webroomba.model.Lidar;

/**
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
public interface LidarCreatorService {

    Lidar createLidar(int[] roomSize);

}
