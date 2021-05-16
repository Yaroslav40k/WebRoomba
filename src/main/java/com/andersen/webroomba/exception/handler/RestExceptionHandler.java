package com.andersen.webroomba.exception.handler;

import com.andersen.webroomba.exception.response.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

/**
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
@ControllerAdvice
public class RestExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestExceptionHandler.class);
    private static final String UNKNOWN_ERROR_TITLE = "INTERNAL_SERVER_ERROR";
    private static final String BAD_ENTITY_TITLE = "UNPROCESSABLE OBJECT FOUND";
    private static final String BAD_JSON = "UNPROCESSABLE JSON FOUND";
    private static final String ERROR_OCCURRED = "ERROR OCCURRED";
    private static final int UNKNOWN_ERROR_STATUS_VALUE = INTERNAL_SERVER_ERROR.value();
    private static final String UNKNOWN_ERROR_MESSAGE = "Our specialists are working on this problem";
    private static final String BAD_JSON_ERROR_MESSAGE = "Error found in JSON structure";

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public ErrorResponse handleIllegalArgument(final IllegalArgumentException exception, final HttpServletResponse response) {
        LOGGER.error(ERROR_OCCURRED, exception);
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        return new ErrorResponse(BAD_ENTITY_TITLE, exception.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public ErrorResponse handleJsonParseException(final HttpMessageNotReadableException exception, final HttpServletResponse response) {
        LOGGER.error(ERROR_OCCURRED, exception);
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        return new ErrorResponse(BAD_JSON, BAD_JSON_ERROR_MESSAGE);
    }


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ErrorResponse handleException(final Exception exception, final HttpServletResponse response) {
        LOGGER.error(ERROR_OCCURRED, exception);
        response.setStatus(UNKNOWN_ERROR_STATUS_VALUE);
        return new ErrorResponse(UNKNOWN_ERROR_TITLE, UNKNOWN_ERROR_MESSAGE);
    }


}
