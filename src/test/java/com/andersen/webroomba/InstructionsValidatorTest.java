package com.andersen.webroomba;

import com.andersen.webroomba.exception.MissingParameterException;
import com.andersen.webroomba.validator.Validator;
import com.andersen.webroomba.validator.implementation.InstructionsValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author Yaroslav Dmitriev (
 * @since 16.05.2021
 */
class InstructionsValidatorTest {

    private final Validator<String> instructionsValidator = new InstructionsValidator();

    @ParameterizedTest
    @ValueSource(strings = {"W"})
    void validate_1LegalInstruction_expectingPositiveResult(String instructions) {
        Assertions.assertDoesNotThrow(() -> instructionsValidator.validate(instructions));
    }

    @ParameterizedTest
    @ValueSource(strings = {"WN"})
    void validate_2LegalInstructions_expectingPositiveResult(String instructions) {
        Assertions.assertDoesNotThrow(() -> instructionsValidator.validate(instructions));
    }

    @ParameterizedTest
    @ValueSource(strings = {"WNE"})
    void validate_3LegalInstructions_expectingPositiveResult(String instructions) {
        Assertions.assertDoesNotThrow(() -> instructionsValidator.validate(instructions));
    }

    @ParameterizedTest
    @ValueSource(strings = {"WNES"})
    void validate_4LegalInstructions_expectingPositiveResult(String instructions) {
        Assertions.assertDoesNotThrow(() -> instructionsValidator.validate(instructions));
    }

    @Test
    void validate_missingInstructions_throwsException() {
        Assertions.assertThrows(MissingParameterException.class, () -> instructionsValidator.validate(null));
    }

    @ParameterizedTest
    @ValueSource(strings = {""})
    void validate_emptyInstructions_throwsException(String instructions) {
        Assertions.assertThrows(MissingParameterException.class, () -> instructionsValidator.validate(instructions));
    }

    @ParameterizedTest
    @ValueSource(strings = {"WNES123"})
    void validate_instructionsWithNumbers_throwsException(String instructions) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> instructionsValidator.validate(instructions));
    }

    @ParameterizedTest
    @ValueSource(strings = {"wnes"})
    void validate_instructionsInLowerCase_throwsException(String instructions) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> instructionsValidator.validate(instructions));
    }

    @ParameterizedTest
    @ValueSource(strings = {"UNKNOWNCOMMAND"})
    void validate_instructionsWithUnknownChars_throwsException(String instructions) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> instructionsValidator.validate(instructions));
    }


}
