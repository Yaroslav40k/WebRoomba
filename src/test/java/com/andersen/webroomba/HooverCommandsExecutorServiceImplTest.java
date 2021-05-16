package com.andersen.webroomba;

import com.andersen.webroomba.model.Hoover;
import com.andersen.webroomba.model.implementation.*;
import com.andersen.webroomba.service.implemantation.HooverCommandsExecutorServiceImpl;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.andersen.webroomba.provider.TestGridProvider.provideTest2x2Grid;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Yaroslav Dmitriev (
 * @since 16.05.2021
 */
class HooverCommandsExecutorServiceImplTest {

    private final HooverCommandsExecutorServiceImpl hooverCommandsExecutorService = new HooverCommandsExecutorServiceImpl();

    @ParameterizedTest
    @CsvSource({"WNES, 1, 0", "SNEW, 0, 1", "NESW, 0, 0"})
    void executeCommands_using2x2GridWithoutDirt_expectedHooverOnFinalPosition(String instructions,int xCoordFinal, int yCoordFinal) {
        RoomGrid grid = provideTest2x2Grid();

        HooverLidar hooverLidar = new HooverLidar();
        hooverLidar.setMaxXCoordinate(1);
        hooverLidar.setMaxYCoordinate(1);

        Hoover testHoover = new RoboticHoover();
        testHoover.setGrid(grid);
        testHoover.setLocation(grid.getGridCells()[0][0]);
        testHoover.setInstructions(instructions);
        testHoover.setLidar(hooverLidar);

        hooverCommandsExecutorService.executeCommands(testHoover);

        assertEquals(xCoordFinal, testHoover.getLocation().getAddress().getXCoordinate());
        assertEquals(yCoordFinal, testHoover.getLocation().getAddress().getYCoordinate());

    }

}
