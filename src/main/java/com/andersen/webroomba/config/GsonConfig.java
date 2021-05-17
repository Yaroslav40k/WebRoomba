package com.andersen.webroomba.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This configuration provides Gson bean.
 *
 * @author Yaroslav Dmitriev (
 * @since 17.05.2021
 */

@Configuration
public class GsonConfig {

    @Bean
    public Gson gson() {
        return new GsonBuilder().create();
    }


}
