package com.andersen.webroomba.service;

import com.andersen.webroomba.model.Hoover;

/**
 * Represents hoover  deployer.
 * Deploys hoover on the grid.
 *
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
public interface HooverDeployerService {

    /**
     * Virtually, deploys hoover on the grid.
     * Sets hoover start position.
     *
     * @param hoover - object to be deployed
     */
    void deploy(Hoover hoover);


}
