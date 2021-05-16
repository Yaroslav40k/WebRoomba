package com.andersen.webroomba.service;

import com.andersen.webroomba.entity.GridCleaningResult;
import com.andersen.webroomba.entity.Input;
import com.andersen.webroomba.entity.Output;

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
    Output saveOutput(Input input, GridCleaningResult result);

    /**
     * Gets all outputs from DB.
     *
     * @return all outputs from data base
     */
    List<Output> getAllOutputs();


}
