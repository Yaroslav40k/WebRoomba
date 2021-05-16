package com.andersen.webroomba.service;

import com.andersen.webroomba.model.Hoover;

/**
 * Represents hoover commands executor in WebRoomba application.
 * Similar to hoover main processor in a real robotic hoovers
 *
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
public interface HooverCommandsExecutorService {

    /**
     * Takes hoovers 'direction' commands and executes them in native order.
     *
     * @param hoover - poor hoover, under executor control.
     */
    void executeCommands(Hoover hoover);


}
