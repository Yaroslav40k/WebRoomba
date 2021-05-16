package com.andersen.webroomba.serializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Component;

/**
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
@Component
public class JsonSerializer {

    public String serializeObject(Object json) {
        Gson jsonCreator = new GsonBuilder().create();
        return jsonCreator.toJson(json);
    }


}
