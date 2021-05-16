package com.andersen.webroomba;

import com.andersen.webroomba.entity.GridConfiguration;
import com.andersen.webroomba.model.implementation.GridCell;
import com.andersen.webroomba.model.implementation.RoomGrid;
import com.andersen.webroomba.service.implemantation.RoomGridCreatorService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Yaroslav Dmitriev (
 * @since 16.05.2021
 */
class RoomGridCreatorServiceTest {

    private final RoomGridCreatorService roomGridCreatorService = new RoomGridCreatorService();

    @ParameterizedTest
    @CsvSource({"5, 5, 0, 0, 1, 1", "10, 10, 1, 1, 2, 3", "100, 100, 50, 60, 27, 28"})
    void createGrid_withValidConfiguration_expectingCreatedGrid(int xAxisGridLength,
                                                                int yAxisGridLength,
                                                                int xHooverCoordinate,
                                                                int yHooverCoordinate,
                                                                int xDirtPatchCoordinate,
                                                                int yDirtPatchCoordinate) {
        GridConfiguration suspiciousConfiguration = new GridConfiguration();
        suspiciousConfiguration.setRoomSize(new int[] {xAxisGridLength, yAxisGridLength});
        suspiciousConfiguration.setCoords(new int[] {xHooverCoordinate, yHooverCoordinate});
        suspiciousConfiguration.setPatches(List.of(new int[] {xDirtPatchCoordinate, yDirtPatchCoordinate}));
        suspiciousConfiguration.setInstructions("WNES");

        RoomGrid expected = new RoomGrid();
        GridCell[][] gridCells = new GridCell[xAxisGridLength][yAxisGridLength];
        GridCell dirtyCell = new GridCell();
        dirtyCell.setDirty(true);
        gridCells[xDirtPatchCoordinate][yDirtPatchCoordinate] = dirtyCell;
        expected.setGridCells(gridCells);
        expected.setHooverStartPosition(new int[] {xHooverCoordinate, yHooverCoordinate});

        RoomGrid actual = roomGridCreatorService.createGrid(suspiciousConfiguration);

        assertNotNull(actual);
        assertEquals(expected.getGridCells().length, actual.getGridCells().length);
        assertEquals(expected.getHooverStartPosition()[0], actual.getHooverStartPosition()[0]);
        assertEquals(expected.getHooverStartPosition()[1], actual.getHooverStartPosition()[1]);
        assertEquals(expected.getGridCells()[xDirtPatchCoordinate][yDirtPatchCoordinate].isDirty(), actual.getGridCells()[xDirtPatchCoordinate][yDirtPatchCoordinate].isDirty());

    }


}
