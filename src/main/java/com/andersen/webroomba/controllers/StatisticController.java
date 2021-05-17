package com.andersen.webroomba.controllers;

import com.andersen.webroomba.dto.InputDto;
import com.andersen.webroomba.dto.OutputDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @author Yaroslav Dmitriev (
 * @since 17.05.2021
 */
public interface StatisticController {

    @ApiOperation(value = "Gets all inputs")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operation was successful"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 404, message = "Bad request, check your input"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    ResponseEntity<List<InputDto>> getAllInputs();

    @ApiOperation(value = "Gets all outputs")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operation was successful"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 404, message = "Bad request, check your input"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    ResponseEntity<List<OutputDto>> getAllOutputs();

}
