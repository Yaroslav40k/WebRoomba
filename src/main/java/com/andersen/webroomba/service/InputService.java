package com.andersen.webroomba.service;

import com.andersen.webroomba.entity.GridConfiguration;
import com.andersen.webroomba.entity.Input;

import java.util.List;


/**
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
public interface InputService {

    /**
     *
     * @param configuration
     * @return
     */
    Input saveInput(GridConfiguration configuration);


    List<Input> getAllInputs();


}
