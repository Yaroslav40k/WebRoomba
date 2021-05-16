package com.andersen.webroomba.model;


/**
 * Represents virtual Lidar, like real hoovers lidar.
 * Checks if an object can move to a next cell.
 *
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
public interface Lidar {

    /**
     * Check if new address is within a grid.
     *
     * @param address - address of a cell on a grid
     * @return true if is allowed to move there
     */
    boolean isWithinTheGrid(CellAddress address);

    /**
     *
     * @param maxXCoordinate
     */
    void setMaxXCoordinate(int maxXCoordinate);

    /**
     *
     * @param maxYCoordinate
     */
    void setMaxYCoordinate(int maxYCoordinate);

}
