package com.andersen.webroomba;

import com.andersen.webroomba.exception.MissingParameterException;
import com.andersen.webroomba.validator.Validator;
import com.andersen.webroomba.validator.implementation.GridSizeValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author Yaroslav Dmitriev (
 * @since 16.05.2021
 */
class GridSizeValidatorTest {

    private final Validator<int[]> gridSizeValidator = new GridSizeValidator();

    @ParameterizedTest
    @CsvSource({"1, 1", "5, 5","5, 6","5, 10", "100, 100", "1000, 10000"})
    void validate_legalGridSize_expectingPositiveResult(int xCoordinate, int yCoordinate) {
        int[] legalGridSize = new int[] {xCoordinate, yCoordinate};
        Assertions.assertDoesNotThrow(() -> gridSizeValidator.validate(legalGridSize));
    }

    @Test
    void validate_missingGridSize_throwsException() {
        Assertions.assertThrows(MissingParameterException.class, () -> gridSizeValidator.validate(null));
    }

    @Test
    void validate_emptyGridSize_throwsException() {
        int[] emptyGridSize = new int[0];
        Assertions.assertThrows(MissingParameterException.class, () -> gridSizeValidator.validate(emptyGridSize));
    }

    @ParameterizedTest
    @CsvSource({"0, 0", "0, 1", "1, 0"})
    void validate_gridSizeWithZeroCoordinate_throwsException(int xCoordinate, int yCoordinate) {
        int[] gridSizeWithZeroCoordinate = new int[] {xCoordinate, yCoordinate};
        Assertions.assertThrows(IllegalArgumentException.class, () -> gridSizeValidator.validate(gridSizeWithZeroCoordinate));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 3, 4, 5, 6, 7, 8, 9, 10})
    void validate_gridSizeWithOnlyOneCoordinate_throwsException(int xCoordinate) {
        int[] gridSizeWithOnlyOneCoordinate = new int[] {xCoordinate};
        Assertions.assertThrows(IllegalArgumentException.class, () -> gridSizeValidator.validate(gridSizeWithOnlyOneCoordinate));
    }

    @ParameterizedTest
    @CsvSource({"0, 0, 0", "0, 1, 1", "1, 1, 1", "2, 3, 4", "10, 100, 1000"})
    void validate_gridSizeWith3Coordinates_throwsException(int xCoordinate, int yCoordinate, int zCoordinate) {
        int[] gridSizeWith3Coordinates = new int[] {xCoordinate, yCoordinate, zCoordinate};
        Assertions.assertThrows(IllegalArgumentException.class, () -> gridSizeValidator.validate(gridSizeWith3Coordinates));
    }


}
