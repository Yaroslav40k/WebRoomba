package com.andersen.webroomba.model.implementation;

import com.andersen.webroomba.model.Cell;
import com.andersen.webroomba.model.Grid;
import com.andersen.webroomba.model.Hoover;
import com.andersen.webroomba.model.Lidar;

/**
 * @author Yaroslav Dmitriev (
 * @since 14.05.2021
 */
public class RoboticHoover implements Hoover {

    private Grid grid;
    private Cell location;
    private String instructions;
    private Lidar lidar;
    private int collectedDirtPatches;

    public void fillDirtContainer () {
        collectedDirtPatches++;
    }

    @Override
    public void deployOn() {
        int[] hooverStartPosition = grid.getHooverStartPosition();
        int xStartCoordForHoover = hooverStartPosition[0];
        int yStartCoordForHoover =hooverStartPosition[1];
        this.setLocation(grid.getGridCells()[xStartCoordForHoover][yStartCoordForHoover]);
    }

    @Override
    public void move(char direction) throws IllegalArgumentException {
        GridCellAddress newHoverLocation = new GridCellAddress(this.getLocation().getAddress().getXCoordinate(), this.getLocation().getAddress().getYCoordinate());
        switch (direction) {
            case ('W'):
                newHoverLocation.setXCoordinate(newHoverLocation.getXCoordinate() - 1);
                break;
            case ('N'):
                newHoverLocation.setYCoordinate(newHoverLocation.getYCoordinate() + 1);
                break;
            case ('E'):
                newHoverLocation.setXCoordinate(newHoverLocation.getXCoordinate() + 1);
                break;
            case ('S'):
                newHoverLocation.setYCoordinate(newHoverLocation.getYCoordinate() - 1);
                break;
            default:
                throw new IllegalArgumentException("Unknown command!");
        }
        if (lidar.isWithinTheGrid(newHoverLocation)) {
            this.setLocation(grid.getGridCells()[newHoverLocation.getXCoordinate()][newHoverLocation.getYCoordinate()]);
        }
    }

    @Override
    public void cleanCell() {
        if (this.getLocation().isDirty()) {
            this.fillDirtContainer();
            this.getLocation().setDirty(false);
        }
    }

    @Override
    public Grid getGrid() {
        return grid;
    }

    @Override
    public String getInstructions() {
        return instructions;
    }

    @Override
    public int getCollectedDirtPatches() {
        return collectedDirtPatches;
    }

    @Override
    public Cell getLocation() {
        return location;
    }

    @Override
    public void setLocation(GridCell gridCell) {
        this.location=gridCell;
    }

    @Override
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    @Override
    public void setGrid(RoomGrid grid) {
             this.grid = grid;
    }

    @Override
    public void setLidar(Lidar lidar) {
          this.lidar =lidar;
    }


}
