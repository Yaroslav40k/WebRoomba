package com.andersen.webroomba.exception;

/**
 * Custom RuntimeException to notify about 'null' or empty parameter in a JSOn file.
 * @see RuntimeException
 * @see IllegalArgumentException
 *
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
public class MissingParameterException extends  IllegalArgumentException{

    public MissingParameterException(String message) {
        super(message);
    }


}
