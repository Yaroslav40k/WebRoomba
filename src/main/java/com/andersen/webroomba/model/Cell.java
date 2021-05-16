package com.andersen.webroomba.model;

/**
 * Basic interface for a cell of some room, where hoover or other object is working.
 *
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
public interface Cell {

    /**
     *
     * @return
     */
    CellAddress getAddress();

    /**
     *
     * @param address
     */
    void setAddress(CellAddress address);


    /**
     *
     * @param dirty
     */
    void setDirty(boolean dirty);


    /**
     *
     * @return
     */
    boolean isDirty();


}
