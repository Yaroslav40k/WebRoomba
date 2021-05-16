package com.andersen.webroomba.exception.response;

/**
 * @author Anthony Webster (awe)
 * @since 17/07/2017
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
