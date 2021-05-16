package com.andersen.webroomba.model.implementation;

import com.andersen.webroomba.model.Grid;

/**
 * @author Yaroslav Dmitriev (
 * @since 14.05.2021
 */
public class RoomGrid implements Grid {

    private GridCell[][] gridCells;
    private int[] hooverStartPosition;

    @Override
    public int[] getHooverStartPosition() {
        return hooverStartPosition;
    }

    @Override
    public GridCell[][] getGridCells() {
        return gridCells;
    }

    @Override
    public void setGridCells(GridCell[][] gridCells) {
        this.gridCells = gridCells;
    }

    @Override
    public void setHooverStartPosition(int[] coords) {
        this.hooverStartPosition = coords;
    }


}
