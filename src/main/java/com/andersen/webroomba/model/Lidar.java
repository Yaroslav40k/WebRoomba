package com.andersen.webroomba.model;


/**
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
public interface Lidar {

    /**
     *
     * @param address
     * @return
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
