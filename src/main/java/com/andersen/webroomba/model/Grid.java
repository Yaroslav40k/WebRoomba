package com.andersen.webroomba.model;

import com.andersen.webroomba.model.implementation.GridCell;

/**
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
public interface Grid {

    /**
     *
     * @return
     */
    int[]  getHooverStartPosition();

    /**
     *
     * @return
     */
    GridCell[][] getGridCells();

    /**
     *
     * @param gridCells
     */
    void setGridCells(GridCell[][] gridCells);


    /**
     *
     * @param coords
     */
    void setHooverStartPosition(int[] coords);


}
