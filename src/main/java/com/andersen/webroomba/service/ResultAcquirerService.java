package com.andersen.webroomba.service;

import com.andersen.webroomba.entity.GridCleaningResult;
import com.andersen.webroomba.model.Hoover;

/**
 * This service collects the result of work from a hoover
 *
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
public interface ResultAcquirerService {

    /**
     * Collects the result of work from a hoover memory.
     *
     * @param hoover hoover, who just finished it`s work
     * @return hoover`s work result
     */
    GridCleaningResult acquireExecutionResults(Hoover hoover);



}
