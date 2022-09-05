package com.andersen.webroomba.service;

import com.andersen.webroomba.model.DirtContainer;
import com.andersen.webroomba.model.Hoover;


public interface DirtContainerService {

    /**
     * Creates a dirt container.
     *
     * @return created dirt container
     */
    DirtContainer createDirtContainer();

    /**
     *
     * @param testHoover
     */
    void cleanContainer(Hoover testHoover);

}
