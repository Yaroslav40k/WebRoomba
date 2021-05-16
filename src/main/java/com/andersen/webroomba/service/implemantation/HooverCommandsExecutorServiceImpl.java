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
        for (char direction : hoover.getInstructions().toCharArray()) {
            hoover.move(direction);
            hoover.cleanCell();
        }


    }


}
