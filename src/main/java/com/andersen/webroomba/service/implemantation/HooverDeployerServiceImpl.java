package com.andersen.webroomba.service.implemantation;

import com.andersen.webroomba.model.Grid;
import com.andersen.webroomba.model.Hoover;
import com.andersen.webroomba.service.HooverDeployerService;
import org.springframework.stereotype.Service;

/**
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
@Service
public class HooverDeployerServiceImpl implements HooverDeployerService {

    @Override
    public void deploy(Hoover hoover) {
        Grid grid = hoover.getGrid();
        int[] hooverStartPosition = grid.getHooverStartPosition();
        int xStartCoordForHoover = hooverStartPosition[0];
        int yStartCoordForHoover = hooverStartPosition[1];
        hoover.setLocation(grid.getGridCells()[xStartCoordForHoover][yStartCoordForHoover]);
    }


}
