package com.andersen.webroomba.validator;

/**
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
public interface Validator<T> {

    /**
     * Performs validation of the suspicious object.
     *
     *
     * @param suspiciousObject
     */
    void  validate  (T suspiciousObject);

}
