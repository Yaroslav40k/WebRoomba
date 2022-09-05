package com.andersen.webroomba;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.andersen.webroomba.model.Hoover;
import com.andersen.webroomba.model.implementation.HooverDirtContainer;
import com.andersen.webroomba.model.implementation.RoboticHoover;
import com.andersen.webroomba.service.implemantation.HooverDirtContainerService;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

public class HooverDirtContainerCleanerTest {

    private final HooverDirtContainerService hooverDirtContainerCleaner = new HooverDirtContainerService();

    @ParameterizedTest
    @ValueSource( ints = {0, 1, 3, 10})
    void cleanHooverDirtContainer_usingDefaultContainerCleaner_expectedHooverDeployedSuccessfully(int dirtPatches) {

        Hoover testHoover = new RoboticHoover();
        testHoover.setDirtContainer(new HooverDirtContainer());
        for (int x=0; x<=dirtPatches; x++) {
            testHoover.fillDirtContainer();
        }

        hooverDirtContainerCleaner.cleanContainer(testHoover);

        assertEquals(testHoover.getCollectedDirtPatches(), 0);
    }
}
