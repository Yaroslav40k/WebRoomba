package com.andersen.webroomba.service;

import com.andersen.webroomba.entity.GridConfiguration;
import com.andersen.webroomba.model.Hoover;
import com.andersen.webroomba.model.implementation.RoomGrid;

/**
 * Represents hoover creator.
 *
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
public interface HooverCreatorService {


    /**
     * Creates a hoover instance using transmitted parameters.
     *
     * @param hooverGrid room grid
     * @param configuration current session configuration
     * @return created hoover
     */
    Hoover createHoover(RoomGrid hooverGrid, GridConfiguration configuration);


}
