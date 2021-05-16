package com.andersen.webroomba.model;

/**
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
     * @param b
     */
    void setDirty(boolean b);


    /**
     *
     * @return
     */
    boolean isDirty();


}
