package com.andersen.webroomba.service;

import com.andersen.webroomba.entity.GridConfiguration;
import com.andersen.webroomba.model.implementation.RoomGrid;

/**
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
public interface GridCreatorService {

    /**
     *
     * @param configuration
     * @return
     */
    RoomGrid createGrid(GridConfiguration configuration);


}
