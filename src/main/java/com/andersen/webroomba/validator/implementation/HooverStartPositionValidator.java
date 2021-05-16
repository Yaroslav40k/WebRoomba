package com.andersen.webroomba.validator.implementation;

import com.andersen.webroomba.entity.GridConfiguration;
import com.andersen.webroomba.exception.MissingParameterException;
import com.andersen.webroomba.validator.Validator;
import org.springframework.stereotype.Component;

/**
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
@Component
public class HooverStartPositionValidator implements Validator<GridConfiguration> {

    @Override
    public void validate(GridConfiguration configuration) {
        int[] startPosition = configuration.getCoords();
        int[] roomSize = configuration.getRoomSize();

        if (startPosition == null || startPosition.length == 0) {
            throw new MissingParameterException("Hoover start position was not specified");
        }

        if (startPosition.length <= 1) {
            throw new IllegalArgumentException(String.format("Not enough parameters  in hoover start position: %s, need 2", startPosition.length));
        }

        if (startPosition.length > 2) {
            throw new IllegalArgumentException(String.format("Too many parameters  in hoover start position: %s, need 2", startPosition.length));
        }

        if (startPosition[0] > roomSize[0]-1 || startPosition[1] > roomSize[1]-1) {
            throw new IllegalArgumentException("Hoover start position is outside of the chosen grid");
        }

    }


}
