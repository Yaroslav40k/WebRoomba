package com.andersen.webroomba.service;

import com.andersen.webroomba.entity.GridConfiguration;
import com.andersen.webroomba.model.Hoover;
import com.andersen.webroomba.model.implementation.RoomGrid;

/**
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
public interface HooverCreatorService {


    /**
     *
     * @param hooverGrid
     * @param configuration
     * @return
     */
    Hoover createHoover(RoomGrid hooverGrid, GridConfiguration configuration);


}
