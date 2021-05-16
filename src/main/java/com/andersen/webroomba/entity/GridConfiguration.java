package com.andersen.webroomba.entity;


import java.io.Serializable;
import java.util.List;

/**
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



