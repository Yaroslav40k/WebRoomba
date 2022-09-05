package com.andersen.webroomba.model.implementation;

import com.andersen.webroomba.model.DirtContainer;

/**
 * @author Yaroslav Dmitriev (
 * @since 05.09.2022
 */
public class HooverDirtContainer implements DirtContainer {

    private int collectedDirtPatches;

    @Override
    public void addDirt () {
        collectedDirtPatches++;
    }

    @Override
    public int getCollectedDirt() {
        return collectedDirtPatches;
    }

    @Override
    public int removeDirt () {
        int removedDirtPatches = collectedDirtPatches;
        collectedDirtPatches = 0;
        return removedDirtPatches;
    }

}