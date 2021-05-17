package com.andersen.webroomba.model.implementation;

import com.andersen.webroomba.model.CellAddress;

/**
 * @author Yaroslav Dmitriev (
 * @since 14.05.2021
 */

public class GridCellAddress implements CellAddress {

    private int xCoordinate;
    private int yCoordinate;

    public GridCellAddress(final int xCoordinate, final int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    @Override
    public int getXCoordinate() {
        return xCoordinate;
    }

    @Override
    public int getYCoordinate() {
        return yCoordinate;
    }

    @Override
    public void setXCoordinate(int xCoordinate) {
          this.xCoordinate=xCoordinate;
    }

    @Override
    public void setYCoordinate(int yCoordinate) {
        this.yCoordinate =yCoordinate;
    }


}
