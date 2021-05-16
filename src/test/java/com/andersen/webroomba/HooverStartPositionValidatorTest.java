package com.andersen.webroomba;

import com.andersen.webroomba.entity.GridConfiguration;
import com.andersen.webroomba.exception.MissingParameterException;
import com.andersen.webroomba.validator.Validator;
import com.andersen.webroomba.validator.implementation.HooverStartPositionValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author Yaroslav Dmitriev (
 * @since 16.05.2021
 */
class HooverStartPositionValidatorTest {

    private final Validator<GridConfiguration> hooverStartPositionValidator = new HooverStartPositionValidator();

    @ParameterizedTest
    @CsvSource({"5, 5, 0, 0", "5, 5, 1, 0", "5, 5, 0, 1", "5, 5, 1, 1", "5, 5, 2, 3", "5, 5, 1, 4"})
    void validate_legalHooverStartPosition_expectingPositiveResult(int xAxisGridLength, int yAxisGridLength, int xHooverCoordinate, int yHooverCoordinate) {
        GridConfiguration configuration = new GridConfiguration();
        configuration.setRoomSize(new int[] {xAxisGridLength, yAxisGridLength});
        configuration.setCoords(new int[] {xHooverCoordinate, yHooverCoordinate});
        Assertions.assertDoesNotThrow(() -> hooverStartPositionValidator.validate(configuration));
    }

    @ParameterizedTest
    @CsvSource({"1, 1", "5, 5", "5, 6", "5, 10", "100, 100", "1000, 10000"})
    void validate_missingHooverStartPosition_throwsException(int xAxisGridLength, int yAxisGridLength) {
        GridConfiguration configuration = new GridConfiguration();
        configuration.setRoomSize(new int[] {xAxisGridLength, yAxisGridLength});
        configuration.setCoords(null);
        Assertions.assertThrows(MissingParameterException.class, () -> hooverStartPositionValidator.validate(configuration));
    }

    @Test
    void validate_emptyHooverStartPosition_throwsException() {
        GridConfiguration configuration = new GridConfiguration();
        configuration.setCoords(new int[0]);
        Assertions.assertThrows(MissingParameterException.class, () -> hooverStartPositionValidator.validate(configuration));
    }


    @ParameterizedTest
    @CsvSource({"1, 1", "5, 5", "5, 6", "5, 10", "100, 100", "1000, 10000"})
    void validate_hooverStartPositionWithZeroCoordinate_throwsException(int xAxisGridLength, int yAxisGridLength) {
        GridConfiguration configuration = new GridConfiguration();
        configuration.setRoomSize(new int[] {xAxisGridLength, yAxisGridLength});
        configuration.setCoords(new int[0]);
        Assertions.assertThrows(IllegalArgumentException.class, () -> hooverStartPositionValidator.validate(configuration));
    }

    @ParameterizedTest
    @CsvSource({"5, 5, 0", "5, 5, 1", "5, 5, 0", "5, 5, 1", "5, 5, 2", "5, 5, 1"})
    void validate_hooverStartPositionWithOnlyOneCoordinate_throwsException(int xAxisGridLength, int yAxisGridLength, int xHooverCoordinate) {
        GridConfiguration configuration = new GridConfiguration();
        configuration.setRoomSize(new int[] {xAxisGridLength, yAxisGridLength});
        configuration.setCoords(new int[] {xHooverCoordinate});
        Assertions.assertThrows(IllegalArgumentException.class, () -> hooverStartPositionValidator.validate(configuration));
    }

    @ParameterizedTest
    @CsvSource({"5, 5, 0, 0, 0", "5, 5, 1, 0, 1", "5, 5, 0, 1 ,2", "5, 5, 1, 1, 3", "5, 5, 2, 3, 4", "5, 5, 1, 4, 5"})
    void validate_hooverStartPositionWith3Coordinates_throwsException(int xAxisGridLength, int yAxisGridLength, int xHooverCoordinate, int yHooverCoordinate, int zHooverCoordinate) {
        GridConfiguration configuration = new GridConfiguration();
        configuration.setRoomSize(new int[] {xAxisGridLength, yAxisGridLength});
        configuration.setCoords(new int[] {xHooverCoordinate, yHooverCoordinate, zHooverCoordinate});
        Assertions.assertThrows(IllegalArgumentException.class, () -> hooverStartPositionValidator.validate(configuration));
    }

    @ParameterizedTest
    @CsvSource({"5, 5, 5, 5", "5, 5, 4, 5", "5, 5, 0, 5", "5, 5, 6, 6", "5, 5, 1, 10", "5, 5, 100, 0"})
    void validate_hooverStartPositionOutOfTheGrid_expectingPositiveResult(int xAxisGridLength, int yAxisGridLength, int xHooverCoordinate, int yHooverCoordinate) {
        GridConfiguration configuration = new GridConfiguration();
        configuration.setRoomSize(new int[] {xAxisGridLength, yAxisGridLength});
        configuration.setCoords(new int[] {xHooverCoordinate, yHooverCoordinate});
        Assertions.assertThrows(IllegalArgumentException.class, () -> hooverStartPositionValidator.validate(configuration));
    }


}
