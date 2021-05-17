package com.andersen.webroomba.entity;

import java.io.Serializable;

/**
 * Basic interface to provide an access to ID column for entities.
 *
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
public interface Identifiable<T extends Serializable> extends Serializable {

    T getId();
}
