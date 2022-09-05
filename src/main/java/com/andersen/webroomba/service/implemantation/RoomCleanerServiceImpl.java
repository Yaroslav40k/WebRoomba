package com.andersen.webroomba.service.implemantation;

import com.andersen.webroomba.entity.inner.GridCleaningResult;
import com.andersen.webroomba.model.Hoover;
import com.andersen.webroomba.service.DirtContainerService;
import com.andersen.webroomba.service.HooverCommandsExecutorService;
import com.andersen.webroomba.service.HooverDeployerService;
import com.andersen.webroomba.service.ResultAcquirerService;
import com.andersen.webroomba.service.RoomCleanerService;
import org.springframework.stereotype.Service;

/**
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
@Service
public class RoomCleanerServiceImpl implements RoomCleanerService {

    private final HooverDeployerService hooverDeployer;
    private final HooverCommandsExecutorService hooverCommandsExecutor;
    private final ResultAcquirerService resultAcquirerService;
    private final DirtContainerService dirtContainerService;

    public RoomCleanerServiceImpl(final HooverDeployerService hooverDeployer,
            final HooverCommandsExecutorService hooverCommandsExecutor,
            final ResultAcquirerService hooverWorkResultAcquirerServiceImpl,
            DirtContainerService dirtContainerService) {
        this.hooverDeployer = hooverDeployer;
        this.hooverCommandsExecutor = hooverCommandsExecutor;
        this.resultAcquirerService = hooverWorkResultAcquirerServiceImpl;
        this.dirtContainerService = dirtContainerService;
    }

    @Override
    public GridCleaningResult cleanRoom(Hoover hoover) {
        hooverDeployer.deploy(hoover);
        hooverCommandsExecutor.executeCommands(hoover);
        dirtContainerService.cleanContainer(hoover);
        return resultAcquirerService.acquireExecutionResults(hoover);
    }


}
