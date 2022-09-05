package com.andersen.webroomba.service.implemantation;

import com.andersen.webroomba.model.DirtContainer;
import com.andersen.webroomba.model.Hoover;
import com.andersen.webroomba.model.implementation.HooverDirtContainer;
import com.andersen.webroomba.service.DirtContainerService;
import org.springframework.stereotype.Service;

@Service
public class HooverDirtContainerService implements DirtContainerService {

    @Override
    public DirtContainer createDirtContainer() {
        return new HooverDirtContainer();
    }

    @Override
    public void cleanContainer(Hoover testHoover) {
        DirtContainer dirtContainer = testHoover.ejectDirtContainer();
        testHoover.setDirtContainer(null);
        dirtContainer.removeDirt();
        testHoover.setDirtContainer(dirtContainer);
    }

}
