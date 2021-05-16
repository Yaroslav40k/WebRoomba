package com.andersen.webroomba.model;

/**
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
public interface CellAddress {

    /**
     *
     * @return
     */
    int getXCoordinate();


    /**
     *
     * @return
     */
    int getYCoordinate();


    /**
     *
     * @param xCoordinate
     */
    void setXCoordinate(int xCoordinate);

    /**
     *
     * @param yCoordinate
     */
    void setYCoordinate(int yCoordinate);


}
