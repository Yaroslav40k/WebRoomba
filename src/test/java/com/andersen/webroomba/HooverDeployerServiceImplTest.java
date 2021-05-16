package com.andersen.webroomba;

import com.andersen.webroomba.model.Hoover;
import com.andersen.webroomba.model.implementation.*;
import com.andersen.webroomba.service.implemantation.HooverDeployerServiceImpl;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.andersen.webroomba.provider.TestGridProvider.provideTest2x2Grid;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Yaroslav Dmitriev (
 * @since 16.05.2021
 */

class HooverDeployerServiceImplTest {

    private final HooverDeployerServiceImpl hooverDeployerService = new HooverDeployerServiceImpl();

    @ParameterizedTest
    @CsvSource({"1, 0", "0, 1", "0, 0"})
    void deployHoover_using2x2Grid_expectedHooverDeployedSuccessfully(int xCoordStart, int yCoordStart) {
        RoomGrid grid = provideTest2x2Grid();
        grid.setHooverStartPosition(new int[]{xCoordStart,yCoordStart});

        Hoover testHoover = new RoboticHoover();
        testHoover.setGrid(grid);

        hooverDeployerService.deploy(testHoover);

        assertEquals(xCoordStart, testHoover.getLocation().getAddress().getXCoordinate());
        assertEquals(yCoordStart, testHoover.getLocation().getAddress().getYCoordinate());
    }
}
