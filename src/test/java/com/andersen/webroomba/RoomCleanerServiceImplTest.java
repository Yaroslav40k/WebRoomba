package com.andersen.webroomba;

import com.andersen.webroomba.entity.inner.GridCleaningResult;
import com.andersen.webroomba.model.Hoover;
import com.andersen.webroomba.model.implementation.RoboticHoover;
import com.andersen.webroomba.service.DirtContainerService;
import com.andersen.webroomba.service.HooverCommandsExecutorService;
import com.andersen.webroomba.service.HooverDeployerService;
import com.andersen.webroomba.service.ResultAcquirerService;
import com.andersen.webroomba.service.implemantation.RoomCleanerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * @author Yaroslav Dmitriev (
 * @since 16.05.2021
 */
@ExtendWith(MockitoExtension.class)
class RoomCleanerServiceImplTest {

    private RoomCleanerServiceImpl roomCleanerService;

    @Mock private HooverDeployerService hooverDeployer;
    @Mock private HooverCommandsExecutorService hooverCommandsExecutor;
    @Mock private ResultAcquirerService resultAcquirerService;
    @Mock private DirtContainerService dirtContainerService;

    @BeforeEach
    void setUp() {
        roomCleanerService = new RoomCleanerServiceImpl(
                hooverDeployer,
                hooverCommandsExecutor,
                resultAcquirerService,
                dirtContainerService);
    }

    @Test
    void cleanRoom_withRoboticHoover_expectingAllOperationsToBeInvoked () {
        doNothing().when(hooverDeployer).deploy(any(Hoover.class));
        doNothing().when(hooverCommandsExecutor).executeCommands(any(Hoover.class));
        when(resultAcquirerService.acquireExecutionResults(any(Hoover.class))).thenReturn(new GridCleaningResult());

        roomCleanerService.cleanRoom(new RoboticHoover());

        verify(hooverDeployer, times(1)).deploy(any(Hoover.class));
        verify(hooverCommandsExecutor, times(1)).executeCommands(any(Hoover.class));
        verify(resultAcquirerService, times(1)).acquireExecutionResults(any(Hoover.class));
    }

}
