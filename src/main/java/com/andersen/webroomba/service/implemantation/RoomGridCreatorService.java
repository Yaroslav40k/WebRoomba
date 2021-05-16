package com.andersen.webroomba.service.implemantation;

import com.andersen.webroomba.entity.GridConfiguration;
import com.andersen.webroomba.model.implementation.GridCell;
import com.andersen.webroomba.model.implementation.GridCellAddress;
import com.andersen.webroomba.model.implementation.RoomGrid;
import com.andersen.webroomba.service.GridCreatorService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
@Service
public class RoomGridCreatorService implements GridCreatorService {

    @Override
    public RoomGrid createGrid(final GridConfiguration configuration) {
        int xDimensionLength = configuration.getRoomSize()[0];
        int yDimensionLength = configuration.getRoomSize()[0];
        RoomGrid grid = new RoomGrid();
        GridCell[][] room = new GridCell[xDimensionLength][yDimensionLength];

        for (int xCoordinate = 0; xCoordinate < room.length; xCoordinate++) {
            for (int yCoordinate = 0; yCoordinate < room[xCoordinate].length; yCoordinate++) {
                GridCell gridCell = new GridCell();
                gridCell.setAddress(new GridCellAddress(xCoordinate, yCoordinate));
                int[] coordinatesOfPossiblyDirtyCell = {xCoordinate, yCoordinate};
                boolean cellIsDirty =  configuration.getPatches().stream().anyMatch(array -> Arrays.equals(coordinatesOfPossiblyDirtyCell, array));

                if (cellIsDirty) {
                    gridCell.setDirty(true);
                }
                room[xCoordinate][yCoordinate] = gridCell;
            }
        }
        grid.setGridCells(room);
        grid.setHooverStartPosition(configuration.getCoords());
        return grid;
    }


}
