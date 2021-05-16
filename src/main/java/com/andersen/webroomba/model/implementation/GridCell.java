package com.andersen.webroomba.model.implementation;

import com.andersen.webroomba.model.Cell;
import com.andersen.webroomba.model.CellAddress;

/**
 * @author Yaroslav Dmitriev (
 * @since 14.05.2021
 */
public class GridCell implements Cell {

    private CellAddress address;
    private boolean dirty;

    public GridCell() {}

    public GridCell(CellAddress address, boolean dirty) {
        this.address = address;
        this.dirty = dirty;
    }

    @Override
    public CellAddress getAddress() {
        return address;
    }

    @Override
    public void setAddress(CellAddress address) {
         this.address=address;
    }

    @Override
    public void setDirty(boolean b) {
       this.dirty=true;
    }

    @Override
    public boolean isDirty() {
        return dirty;
    }


}
