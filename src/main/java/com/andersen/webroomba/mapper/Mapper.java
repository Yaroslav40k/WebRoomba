package com.andersen.webroomba.mapper;

import java.util.List;

/**
 * Represents typical mapper interface.
 *
 * @author Yaroslav Dmitriev (
 * @since 17.05.2021
 */
public interface Mapper<T,E> {

    /**
     * Maps one java object into another one
     *
     * @param object some java object to map
     * @return new java object
     */
    T map (E object);

    /**
     * Maps a list of java objects into  a list of other java objects
     *
     * @param object some java object to map
     * @return new java object
     */
    List<T> map (List<E> object);

}
