package com.andersen.webroomba.service;

import com.andersen.webroomba.entity.GridCleaningResult;
import com.andersen.webroomba.model.Hoover;

/**
 * This service performs all operations, needed to clean a room.
 *
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
public interface RoomCleanerService {

    /**
     * Proceeds with a clean operation.
     * Pushes hoover deployer, hoover main executor and, finally result acquirer.
     *
     * @param hoover who will clean the room
     * @return results of a cleaning opeartion
     */
    GridCleaningResult cleanRoom(Hoover hoover);

}
