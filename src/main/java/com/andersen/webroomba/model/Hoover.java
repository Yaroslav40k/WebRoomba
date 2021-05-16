package com.andersen.webroomba.model;

import com.andersen.webroomba.model.implementation.GridCell;
import com.andersen.webroomba.model.implementation.RoomGrid;

/**
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
public interface Hoover {

    /**
     * Fills hoover`s container with collected stuff.
     */
    void fillDirtContainer ();


    /**
     * Deploy`s  a hoover on the grid.
     *
     */
    void deployOn();

    Grid getGrid();

    /**
     *
     * @return
     */
    String getInstructions();

    /**
     *
     * @return
     */
    int getCollectedDirtPatches();

    /**
     *
     * @return
     */
    Cell getLocation();

    /**
     *
     * @param gridCell
     */
    void setLocation(GridCell gridCell);

    /**
     *
     * @param direction
     */
    void move(char direction) throws IllegalArgumentException;

    /**
     *
     */
    void cleanCell();

    /**
     *
     * @param instructions
     */
    void setInstructions(String instructions);


    /**
     *
     * @param grid
     */
    void setGrid(RoomGrid grid);

    /**
     *
     * @param lidar
     */
    void setLidar(Lidar lidar);


}
