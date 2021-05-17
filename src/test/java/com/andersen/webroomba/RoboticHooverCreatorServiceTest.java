package com.andersen.webroomba;

import com.andersen.webroomba.entity.inner.GridConfiguration;
import com.andersen.webroomba.model.Hoover;
import com.andersen.webroomba.model.implementation.HooverLidar;
import com.andersen.webroomba.model.implementation.RoomGrid;
import com.andersen.webroomba.service.LidarCreatorService;
import com.andersen.webroomba.service.implemantation.RoboticHooverCreatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * @author Yaroslav Dmitriev (
 * @since 16.05.2021
 */

@ExtendWith(MockitoExtension.class)
class RoboticHooverCreatorServiceTest {

    private RoboticHooverCreatorService roboticHooverCreatorService;

    @Mock private LidarCreatorService lidarCreatorService;

    @BeforeEach
    void setUp() {
        roboticHooverCreatorService = new RoboticHooverCreatorService(lidarCreatorService);
    }

    @ParameterizedTest
    @CsvSource({"WNES, 5, 5", "SNEW, 10, 10", "NESW, 50, 50"})
    void createRoboticHoover_withValidConfiguration_expectingCreatedRoboticHoover (String instructions,int xAxisGridLength, int yAxisGridLength) {
        RoomGrid testGrid = new RoomGrid();
        GridConfiguration suspiciousConfiguration = new GridConfiguration();
        suspiciousConfiguration.setInstructions(instructions);
        suspiciousConfiguration.setRoomSize(new int[]{xAxisGridLength, yAxisGridLength});

        when(lidarCreatorService.createLidar(any(int [].class))).thenReturn(new HooverLidar());

        Hoover actual = roboticHooverCreatorService.createHoover(testGrid, suspiciousConfiguration);

        assertNotNull(actual);
        assertEquals(testGrid, actual.getGrid());
        assertEquals(instructions, actual.getInstructions());
    }

}
