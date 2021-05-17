package com.andersen.webroomba.controllers.implementation;

import com.andersen.webroomba.controllers.StatisticController;
import com.andersen.webroomba.dto.InputDto;
import com.andersen.webroomba.dto.OutputDto;
import com.andersen.webroomba.entity.implementation.InputEntity;
import com.andersen.webroomba.entity.implementation.OutputEntity;
import com.andersen.webroomba.mapper.Mapper;
import com.andersen.webroomba.service.InputService;
import com.andersen.webroomba.service.OutputService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This controller was not described in test task requirements.
 * Created only to show the result of persistance layer work.
 *
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
@RestController
@RequestMapping(value = "/api/statistic")
public class StatisticControllerImpl implements StatisticController {

    private final InputService inputService;
    private final OutputService outputService;
    private final Mapper<InputDto, InputEntity> inputMapper;
    private final Mapper<OutputDto, OutputEntity> outputMapper;

    public StatisticControllerImpl(final InputService inputService,
                                   final OutputService outputService,
                                   final Mapper<InputDto, InputEntity> inputMapper,
                                   final Mapper<OutputDto, OutputEntity> outputMapper) {
        this.inputService = inputService;
        this.outputService = outputService;
        this.inputMapper = inputMapper;
        this.outputMapper = outputMapper;
    }

    @Override
    @GetMapping("/inputs")
    public ResponseEntity<List<InputDto>> getAllInputs() {
        List<InputDto> body = inputMapper.map(inputService.getAllInputs());
        return ResponseEntity.ok(body);
    }

    @Override
    @GetMapping("/outputs")
    public ResponseEntity<List<OutputDto>> getAllOutputs() {
        List<OutputDto> body = outputMapper.map(outputService.getAllOutputs());
        return ResponseEntity.ok(body);
    }

}
