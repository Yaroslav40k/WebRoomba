package com.andersen.webroomba.provider;

import com.andersen.webroomba.model.implementation.GridCell;
import com.andersen.webroomba.model.implementation.GridCellAddress;
import com.andersen.webroomba.model.implementation.RoomGrid;

/**
 * @author Yaroslav Dmitriev (
 * @since 16.05.2021
 */
public class TestGridProvider {

    public static RoomGrid provideTest2x2Grid() {
        RoomGrid grid = new RoomGrid();
        GridCell[][] gridCells = new GridCell[2][2];
        gridCells[0][0] = new GridCell(new GridCellAddress(0,0),false);
        gridCells[0][1] = new GridCell(new GridCellAddress(0,1),false);
        gridCells[1][0] = new GridCell(new GridCellAddress(1,0),false);
        gridCells[1][1] = new GridCell(new GridCellAddress(1,1),false);
        grid.setGridCells(gridCells);
        return grid;
    }

}
