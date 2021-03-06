package com.andersen.webroomba.entity.inner;

import java.io.Serializable;

/**
 * This class represents the result of a hoover work.
 * How many dirt patches were collected and what is hoover`s final position on the grid.
 *
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
public class GridCleaningResult implements Serializable {

    private int[] coords;
    private int patches;

    public GridCleaningResult() {}

    public GridCleaningResult(int[] coords, int patches) {
        this.coords = coords;
        this.patches = patches;
    }

    public int[] getCoords() {
        return coords;
    }

    public void setCoords(int[] coords) {
        this.coords = coords;
    }

    public int getPatches() {
        return patches;
    }

    public void setPatches(int patches) {
        this.patches = patches;
    }


}

