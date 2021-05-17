package com.andersen.webroomba;

import com.andersen.webroomba.entity.inner.GridConfiguration;
import com.andersen.webroomba.validator.implementation.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * @author Yaroslav Dmitriev (
 * @since 16.05.2021
 */
@ExtendWith(MockitoExtension.class)
class ConfigurationValidatorTest {

    private ConfigurationValidator configurationValidator;

    @Mock
    private GridSizeValidator gridSizeValidator;
    @Mock
    private HooverStartPositionValidator hooverStartPositionValidator;
    @Mock
    private DirtPositionsValidator dirtPositionsValidator;
    @Mock
    private InstructionsValidator instructionsValidator;

    @BeforeEach
    void setUp() {
        configurationValidator = new ConfigurationValidator(gridSizeValidator,
                hooverStartPositionValidator,
                dirtPositionsValidator,
                instructionsValidator);
    }

    @Test
    void validate_thatAllValidatorsWereExecuted_expectingPositiveResult () {
        doNothing().when(gridSizeValidator).validate(any(int[].class));
        doNothing().when(hooverStartPositionValidator).validate(any(GridConfiguration.class));
        doNothing().when(dirtPositionsValidator).validate(anyList());
        doNothing().when(instructionsValidator).validate(any(String.class));

        GridConfiguration suspiciousConfiguration = new GridConfiguration();
        suspiciousConfiguration.setRoomSize(new int[]{5,5});
        suspiciousConfiguration.setCoords(new int[]{0,0});
        suspiciousConfiguration.setPatches(List.of(new int[]{1,1}));
        suspiciousConfiguration.setInstructions("WNES");
        configurationValidator.validate(suspiciousConfiguration);

        verify(gridSizeValidator, times(1)).validate(any(int[].class));
        verify(hooverStartPositionValidator, times(1)).validate(any(GridConfiguration.class));
        verify(dirtPositionsValidator, times(1)).validate(anyList());
        verify(instructionsValidator, times(1)).validate(any(String.class));
    }


}
