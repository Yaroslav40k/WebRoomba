package com.andersen.webroomba.controller;

import com.andersen.webroomba.dto.InputDto;
import com.andersen.webroomba.dto.OutputDto;
import com.andersen.webroomba.mapper.InputToDtoMapper;
import com.andersen.webroomba.mapper.OutputToDtoMapper;
import com.andersen.webroomba.service.InputService;
import com.andersen.webroomba.service.OutputService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
@RestController
@RequestMapping(value = "/api/statistic")
public class StatisticController {

    private final InputService inputService;
    private final OutputService outputService;
    private final InputToDtoMapper inputToDtoMapper;
    private final OutputToDtoMapper outputToDtoMapper;

    public StatisticController(InputService inputService,
                               OutputService outputService,
                               InputToDtoMapper inputToDtoMapper,
                               OutputToDtoMapper outputToDtoMapper) {
        this.inputService = inputService;
        this.outputService = outputService;
        this.inputToDtoMapper = inputToDtoMapper;
        this.outputToDtoMapper = outputToDtoMapper;
    }

    @GetMapping("/inputs")
    public ResponseEntity<List<InputDto>> getAllInputs() {
        List<InputDto> body = inputService.getAllInputs().stream().map(inputToDtoMapper::map).collect(Collectors.toList());
        return ResponseEntity.ok(body);
    }

    @GetMapping("/outputs")
    public ResponseEntity<List<OutputDto>> getAllOutputs() {
        List<OutputDto> body = outputService.getAllOutputs().stream().map(outputToDtoMapper::map).collect(Collectors.toList());
        return ResponseEntity.ok(body);
    }

}
