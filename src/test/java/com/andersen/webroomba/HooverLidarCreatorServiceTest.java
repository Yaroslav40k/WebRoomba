package com.andersen.webroomba;

import com.andersen.webroomba.service.implemantation.HooverLidarCreatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author Yaroslav Dmitriev (
 * @since 16.05.2021
 */
class HooverLidarCreatorServiceTest {

    private final HooverLidarCreatorService hooverLidarCreatorService = new HooverLidarCreatorService();

    @ParameterizedTest
    @CsvSource({"1, 1", "5, 5","5, 6","5, 10", "100, 100", "1000, 10000"})
    void validate_legalGridSize_expectingPositiveResult(int xAxisGridLength, int yAxisGridLength) {
        int[] roomSize = new int[] {xAxisGridLength, yAxisGridLength};
        Assertions.assertDoesNotThrow(() -> hooverLidarCreatorService.createLidar(roomSize));
    }

}
