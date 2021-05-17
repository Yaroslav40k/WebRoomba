package com.andersen.webroomba.entity;

import java.io.Serializable;
import java.util.List;

/**
 * This class holds all the information, needed to fire up the application 'run' method.
 * @see com.andersen.webroomba.controller.ActionController
 *
 * roomSize - size of a grid (X and Y length)
 * coords - hoover start position (X and Y coordinates)
 * patches - dirt patches position (X and Y coordinates)
 * instructions - chars, dedicated to show direction for hoover movements
 *
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
public class GridConfiguration implements Serializable {

    private int[] roomSize;
    private int[] coords;
    private List<int[]> patches;
    private String instructions;

    public GridConfiguration(){}

    public GridConfiguration(int[] roomSize, int[] coords, List<int[]> patches, String instructions) {
        this.roomSize = roomSize;
        this.coords = coords;
        this.patches = patches;
        this.instructions = instructions;
    }

    public int[] getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(int[] roomSize) {
        this.roomSize = roomSize;
    }

    public int[] getCoords() {
        return coords;
    }

    public void setCoords(int[] coords) {
        this.coords = coords;
    }

    public List<int[]> getPatches() {
        return patches;
    }

    public void setPatches(List<int[]> patches) {
        this.patches = patches;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }


}



