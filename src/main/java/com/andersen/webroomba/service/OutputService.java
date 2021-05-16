package com.andersen.webroomba.service;

import com.andersen.webroomba.entity.GridCleaningResult;
import com.andersen.webroomba.entity.Input;
import com.andersen.webroomba.entity.Output;

import java.util.List;

/**
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
public interface OutputService {

    /**
     *  @param input
     * @param result
     * @return
     */
    Output saveOutput(Input input, GridCleaningResult result);

    List<Output> getAllOutputs();


}
