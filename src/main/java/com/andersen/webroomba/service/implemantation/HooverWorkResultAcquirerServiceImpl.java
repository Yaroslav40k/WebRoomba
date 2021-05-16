package com.andersen.webroomba.service.implemantation;

import com.andersen.webroomba.entity.GridCleaningResult;
import com.andersen.webroomba.model.Hoover;
import com.andersen.webroomba.service.ResultAcquirerService;
import org.springframework.stereotype.Service;

/**
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
@Service
public class HooverWorkResultAcquirerServiceImpl implements ResultAcquirerService {

    @Override
    public GridCleaningResult acquireExecutionResults(Hoover hoover) {
        int[] hooverFinalPosition = {hoover.getLocation().getAddress().getXCoordinate(), hoover.getLocation().getAddress().getYCoordinate()};
        return  new GridCleaningResult(hooverFinalPosition, hoover.getCollectedDirtPatches());
    }


}
