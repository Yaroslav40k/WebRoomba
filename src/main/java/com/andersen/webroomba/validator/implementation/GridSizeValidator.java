package com.andersen.webroomba.validator.implementation;

import com.andersen.webroomba.exception.MissingParameterException;
import com.andersen.webroomba.validator.Validator;
import org.springframework.stereotype.Component;

/**
 * Validates grid size settings.
 *
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
@Component
public class GridSizeValidator implements Validator<int[]> {

    @Override
    public void validate(int[] gridSize) {

        if (gridSize == null || gridSize.length == 0) {
            throw new MissingParameterException("Grid size was not specified");
        }

        if (gridSize.length <= 1) {
            throw new IllegalArgumentException(String.format("Not enough parameters  in grid size: %s, need 2", gridSize.length));
        }

        if (gridSize.length > 2) {
            throw new IllegalArgumentException(String.format("Too many parameters  in grid size: %s, need 2", gridSize.length));
        }

        if (gridSize[0] == 0 || gridSize[1] == 0) {
            throw new IllegalArgumentException("Grid size was not specified properly. It can`t be 0:0");
        }

    }


}
