package com.andersen.webroomba.entity.basic;

import java.io.Serializable;

/**
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
public interface Identifiable<T extends Serializable> extends Serializable {

    T getId();
}
