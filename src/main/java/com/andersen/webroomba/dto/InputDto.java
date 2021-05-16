package com.andersen.webroomba.dto;

import com.fasterxml.jackson.annotation.JsonRawValue;
import java.time.LocalDateTime;

/**
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
public class InputDto {

    @JsonRawValue
    private String configuration;

    private LocalDateTime creationDate;


    public void setConfiguration(String configuration) {
        this.configuration = configuration;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }


}
