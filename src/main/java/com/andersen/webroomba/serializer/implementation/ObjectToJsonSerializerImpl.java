package com.andersen.webroomba.serializer.implementation;

import com.andersen.webroomba.serializer.ObjectToJsonSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Component;

/**
 *
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
@Component
public class ObjectToJsonSerializerImpl implements ObjectToJsonSerializer {

    private final Gson jsonCreator;

    public ObjectToJsonSerializerImpl(final Gson jsonCreator) {
        this.jsonCreator = jsonCreator;
    }

    public String serializeObject(final Object json) {
        return jsonCreator.toJson(json);
    }


}
