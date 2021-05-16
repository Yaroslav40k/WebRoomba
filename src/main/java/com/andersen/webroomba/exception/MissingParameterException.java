package com.andersen.webroomba.exception;

/**
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
public class MissingParameterException extends  IllegalArgumentException{

    public MissingParameterException(String message) {
        super(message);
    }


}
