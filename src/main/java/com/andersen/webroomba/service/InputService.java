package com.andersen.webroomba.service;

import com.andersen.webroomba.entity.inner.GridConfiguration;
import com.andersen.webroomba.entity.implementation.InputEntity;

import java.util.List;


/**
 * Performs operations over Input entity
 *
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
public interface InputService {

    /**
     * Saves input into DB
     *
     * @param configuration core model, to be saved in Input object.
     * @return saved Input entity.
     */
    InputEntity saveInput(GridConfiguration configuration);

    /**
     * Gets all inputs from DB.
     *
     * @return all inputs from data base
     */
    List<InputEntity> getAllInputs();


}
