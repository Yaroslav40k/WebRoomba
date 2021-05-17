package com.andersen.webroomba.service.implemantation;

import com.andersen.webroomba.entity.inner.GridCleaningResult;
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
    public GridCleaningResult acquireExecutionResults(final Hoover hoover) {
        int xCoordinate = hoover.getLocation().getAddress().getXCoordinate();
        int yCoordinate = hoover.getLocation().getAddress().getYCoordinate();
        int[] hooverFinalPosition = {xCoordinate, yCoordinate};
        return  new GridCleaningResult(hooverFinalPosition, hoover.getCollectedDirtPatches());
    }


}
