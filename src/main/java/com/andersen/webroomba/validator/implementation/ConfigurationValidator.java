package com.andersen.webroomba.validator.implementation;

import com.andersen.webroomba.entity.GridConfiguration;
import com.andersen.webroomba.validator.Validator;
import org.springframework.stereotype.Component;

/**
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
@Component
public class ConfigurationValidator implements Validator<GridConfiguration> {

    private final GridSizeValidator gridSizeValidator;
    private final HooverStartPositionValidator hooverStartPositionValidator;
    private final DirtPositionsValidator dirtPositionsValidator;
    private final InstructionsValidator instructionsValidator;

    public ConfigurationValidator(GridSizeValidator gridSizeValidator,
                                  HooverStartPositionValidator hooverStartPositionValidator,
                                  DirtPositionsValidator dirtPositionsValidator,
                                  InstructionsValidator instructionsValidator) {
        this.gridSizeValidator = gridSizeValidator;
        this.hooverStartPositionValidator = hooverStartPositionValidator;
        this.dirtPositionsValidator = dirtPositionsValidator;
        this.instructionsValidator = instructionsValidator;
    }

    @Override
    public void validate(GridConfiguration suspiciousConfiguration) {
        gridSizeValidator.validate(suspiciousConfiguration.getRoomSize());
        hooverStartPositionValidator.validate(suspiciousConfiguration);
        dirtPositionsValidator.validate(suspiciousConfiguration.getPatches());
        instructionsValidator.validate(suspiciousConfiguration.getInstructions());
    }


}
