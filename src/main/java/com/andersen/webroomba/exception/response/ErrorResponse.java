package com.andersen.webroomba.exception.response;

/**
 * Custom class to pass an information about application exception  in  HTTP response.
 *
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
public class ErrorResponse {

    private final String message;
    private final String description;

    public ErrorResponse(String message, String description) {
        this.message = message;
        this.description = description;
    }


    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }


}
