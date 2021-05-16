package com.andersen.webroomba;

import com.andersen.webroomba.model.Hoover;
import com.andersen.webroomba.model.implementation.GridCell;
import com.andersen.webroomba.model.implementation.GridCellAddress;
import com.andersen.webroomba.model.implementation.RoboticHoover;
import com.andersen.webroomba.service.implemantation.HooverWorkResultAcquirerServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author Yaroslav Dmitriev (
 * @since 16.05.2021
 */
class HooverWorkResultAcquirerServiceImplTest {

    private final HooverWorkResultAcquirerServiceImpl hooverWorkResultAcquirerServiceImpl = new HooverWorkResultAcquirerServiceImpl();

    @ParameterizedTest
    @CsvSource({"1, 1", "5, 5","5, 6","5, 10", "100, 100", "1000, 10000"})
    void acquireHooverWorkResults_fromLegalFinishPosition_expectingPositiveResult(int xCoordinate, int yCoordinate) {
        Hoover hoover = new RoboticHoover();
        hoover.setLocation(new GridCell(new GridCellAddress(xCoordinate,yCoordinate),false));
        Assertions.assertDoesNotThrow(() -> hooverWorkResultAcquirerServiceImpl.acquireExecutionResults(hoover));
    }
}
