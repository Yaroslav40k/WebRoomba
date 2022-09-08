package com.andersen.webroomba.service.implemantation;

import com.andersen.webroomba.model.DirtContainer;
import com.andersen.webroomba.model.Hoover;
import com.andersen.webroomba.model.implementation.HooverDirtContainer;
import com.andersen.webroomba.service.DirtContainerService;
import org.springframework.stereotype.Service;

/**
 * The{@code HooverDirtContainerService} represents a command panel for a dirt container instance.
 */
@Service
public class HooverDirtContainerService implements DirtContainerService {

    /**
     * Creates an eternal dirt container of unlimited size.
     *
     * @return created dirt container
     */
    @Override
    public DirtContainer createDirtContainer() {
        return new HooverDirtContainer();
    }

    /**
     * Removes all dirt from a container. Can't store dirt somewhere, so  while using
     * this method think about it like "you are going to make dirt disappear!"(C).
     *
     * @param testHoover hoover, you are going to free from dirt
     */
    @Override
    public void cleanContainer(Hoover testHoover) {
        DirtContainer dirtContainer = testHoover.getDirtContainer();
        testHoover.setDirtContainer(null);
        dirtContainer.removeDirt();
        testHoover.setDirtContainer(dirtContainer);
    }

}
