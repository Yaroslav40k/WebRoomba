package com.andersen.webroomba.model;

import com.andersen.webroomba.model.implementation.GridCell;
import com.andersen.webroomba.model.implementation.RoomGrid;

/**
 * Basic interface for a hoover.
 *
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
public interface Hoover {

    /**
     * Fills hoover`s container with collected stuff.
     */
    void fillDirtContainer ();

    /**
     * Moves a hoover in a transmitted direction.
     *
     * @param direction - a char from compass - could be W-N-E-S
     */
    void move(char direction) throws IllegalArgumentException;

    /**
     * Checks, if a cell is dirty, and it is....
     * cleans a cell from dirt and collects it to a hoover`s container
     *
     */
    void cleanCell();


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

    /**
     * Removes dirt container from hoover.
     */
    DirtContainer ejectDirtContainer();

    /**
     *
     * @param dirtContainer
     */
    void setDirtContainer(DirtContainer dirtContainer);


}
