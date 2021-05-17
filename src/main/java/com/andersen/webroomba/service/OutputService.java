package com.andersen.webroomba.service;

import com.andersen.webroomba.entity.inner.GridCleaningResult;
import com.andersen.webroomba.entity.implementation.InputEntity;
import com.andersen.webroomba.entity.implementation.OutputEntity;

import java.util.List;

/**
 * Performs operations over Output entity
 *
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
public interface OutputService {

    /**
     * Saves output into DB
     *
     * @param result core model, to be saved in Output object.
     * @return saved Output entity.
     */
    OutputEntity saveOutput(InputEntity input, GridCleaningResult result);

    /**
     * Gets all outputs from DB.
     *
     * @return all outputs from data base
     */
    List<OutputEntity> getAllOutputs();


}
