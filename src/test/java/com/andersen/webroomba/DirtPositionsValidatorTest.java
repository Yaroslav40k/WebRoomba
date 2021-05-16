package com.andersen.webroomba;

import com.andersen.webroomba.validator.Validator;
import com.andersen.webroomba.validator.implementation.DirtPositionsValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

/**
 * @author Yaroslav Dmitriev (
 * @since 16.05.2021
 */

class DirtPositionsValidatorTest {

    private final Validator<List<int[]>> dirtPositionsValidator = new DirtPositionsValidator();

    @ParameterizedTest
    @CsvSource({"0, 0", "0, 1", "1, 1", "2, 3", "10, 100", "100, 1000"})
    void validate_legalDirtPosition_expectingPositiveResult(int xCoordinate, int yCoordinate) {
        List<int[]> legalDirtPosition = List.of(new int[] {xCoordinate, yCoordinate});
        Assertions.assertDoesNotThrow(() -> dirtPositionsValidator.validate(legalDirtPosition));
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,3,4,5,6,7,8,9,10})
    void validate_dirtPositionWithOnlyOneCoordinate_throwsException(int xCoordinate) {
        List<int[]> dirtPositionWithOnlyOneCoordinate = List.of(new int[] {xCoordinate});
        Assertions.assertThrows(IllegalArgumentException.class, () -> dirtPositionsValidator.validate(dirtPositionWithOnlyOneCoordinate));
    }

    @ParameterizedTest
    @CsvSource({"0, 0, 0", "0, 1, 1", "1, 1, 1", "2, 3, 4", "10, 100, 1000"})
    void validate_dirtPositionWith3Coordinates_throwsException(int xCoordinate, int yCoordinate, int zCoordinate) {
        List<int[]> dirtPositionWith3Coordinates = List.of(new int[] {xCoordinate, yCoordinate, zCoordinate});
        Assertions.assertThrows(IllegalArgumentException.class, () -> dirtPositionsValidator.validate(dirtPositionWith3Coordinates));
    }


}
