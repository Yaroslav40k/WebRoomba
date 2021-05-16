package com.andersen.webroomba.service;

import com.andersen.webroomba.entity.GridConfiguration;
import com.andersen.webroomba.entity.Input;

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
    Input saveInput(GridConfiguration configuration);

    /**
     * Gets all inputs from DB.
     *
     * @return all inputs from data base
     */
    List<Input> getAllInputs();


}
