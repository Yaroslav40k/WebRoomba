package com.andersen.webroomba.service;

import com.andersen.webroomba.entity.inner.GridConfiguration;
import com.andersen.webroomba.model.implementation.RoomGrid;

/**
 * Represents grid creator in WebRoomba application.
 *
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
public interface GridCreatorService {

    /**
     * Creates a grid using transmitted configuration
     *
     * @param configuration
     * @return created grid
     */
    RoomGrid createGrid(GridConfiguration configuration);


}
