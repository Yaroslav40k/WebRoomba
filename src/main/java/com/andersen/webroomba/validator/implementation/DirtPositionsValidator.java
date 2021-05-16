package com.andersen.webroomba.validator.implementation;

import com.andersen.webroomba.validator.Validator;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
@Service
public class DirtPositionsValidator implements Validator<List<int[]>> {

    @Override
    public void validate(List<int[]> dirtLocations) {

        if (dirtLocations != null && !dirtLocations.isEmpty()) {
            dirtLocations.forEach(this::checkDirtLocationCoordinates);
        }
    }

    private void checkDirtLocationCoordinates (int[] coordinate) {
        if (coordinate.length <= 1) {
            throw new IllegalArgumentException(String.format("Some dirt coordinates don`t have enough parameters: %s, need 2", coordinate.length));
        }

        if (coordinate.length > 2) {
            throw new IllegalArgumentException(String.format("Some dirt coordinates have too many parameters: %s, need 2", coordinate.length));
        }
    }


}
