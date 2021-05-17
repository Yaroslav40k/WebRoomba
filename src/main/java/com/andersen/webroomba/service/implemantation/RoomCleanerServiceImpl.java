package com.andersen.webroomba.service.implemantation;

import com.andersen.webroomba.entity.inner.GridCleaningResult;
import com.andersen.webroomba.model.Hoover;
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

    public RoomCleanerServiceImpl(final HooverDeployerService hooverDeployer,
                                  final HooverCommandsExecutorService hooverCommandsExecutor,
                                  final ResultAcquirerService hooverWorkResultAcquirerServiceImpl) {
        this.hooverDeployer = hooverDeployer;
        this.hooverCommandsExecutor = hooverCommandsExecutor;
        this.resultAcquirerService = hooverWorkResultAcquirerServiceImpl;
    }

    @Override
    public GridCleaningResult cleanRoom(Hoover hoover) {
        hooverDeployer.deploy(hoover);
        hooverCommandsExecutor.executeCommands(hoover);
        return resultAcquirerService.acquireExecutionResults(hoover);
    }


}
