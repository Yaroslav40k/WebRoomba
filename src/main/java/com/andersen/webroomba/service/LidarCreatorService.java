package com.andersen.webroomba.service;

import com.andersen.webroomba.model.Lidar;

/**
 * Represents hoobers lidar creator service.
 *
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
public interface LidarCreatorService {

    /**
     * Creates lidar based on room size.
     * Based on this data lidar will be able to know room limits(walls).
     *
     * @param roomSize really, room/grid size in cells
     * @return created Lidar
     */
    Lidar createLidar(int[] roomSize);

}
