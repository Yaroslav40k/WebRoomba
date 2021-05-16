package com.andersen.webroomba.service;

import com.andersen.webroomba.entity.GridCleaningResult;
import com.andersen.webroomba.model.Hoover;

/**
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
public interface ResultAcquirerService {

    GridCleaningResult acquireExecutionResults(Hoover hoover);



}
