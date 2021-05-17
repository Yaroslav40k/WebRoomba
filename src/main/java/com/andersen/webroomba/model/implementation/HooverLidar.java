package com.andersen.webroomba.model.implementation;

import com.andersen.webroomba.model.CellAddress;
import com.andersen.webroomba.model.Lidar;

/**
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
public class HooverLidar implements Lidar {

    private static final int MIN_X_COORDINATE= 0;
    private static final  int MIN_Y_COORDINATE = 0;

    private int maxXCoordinate;
    private int maxYCoordinate;

    @Override
    public boolean isWithinTheGrid(final CellAddress address) {
        boolean withinXDimensionLimits = address.getXCoordinate() <= maxXCoordinate && address.getXCoordinate() >= MIN_X_COORDINATE;
        boolean withinYDimensionLimits = address.getYCoordinate() <= maxYCoordinate && address.getYCoordinate() >= MIN_Y_COORDINATE;
        return withinXDimensionLimits && withinYDimensionLimits;
    }

    @Override
    public void setMaxXCoordinate(int maxXCoordinate) {
        this.maxXCoordinate=maxXCoordinate;
    }

    @Override
    public void setMaxYCoordinate(int maxYCoordinate) {
        this.maxYCoordinate = maxYCoordinate;
    }


}
