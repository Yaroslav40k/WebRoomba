package com.andersen.webroomba.serializer;

/**
 * Serializes Java objects to JSON string using Gson library.
 *
 * @author Yaroslav Dmitriev (
 * @since 17.05.2021
 */
public interface ObjectToJsonSerializer {

    /**
     * Serializes Java object in a JSON string.
     *
     * @param json an object to serialize
     * @return JSON string
     */
    String serializeObject(Object json);

}
