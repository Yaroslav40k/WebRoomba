package com.andersen.webroomba.service.implemantation;

import com.andersen.webroomba.model.Hoover;
import com.andersen.webroomba.service.HooverCommandsExecutorService;
import org.springframework.stereotype.Service;

/**
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
@Service
public class HooverCommandsExecutorServiceImpl implements HooverCommandsExecutorService {

    public void executeCommands(Hoover hoover) {
        final char[] directions = hoover.getInstructions().toCharArray();
        for (char direction : directions) {
            hoover.move(direction);
            hoover.cleanCell();
        }
    }


}
