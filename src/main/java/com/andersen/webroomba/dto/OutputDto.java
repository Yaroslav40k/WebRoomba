package com.andersen.webroomba.dto;

import com.fasterxml.jackson.annotation.JsonRawValue;

import java.time.LocalDateTime;

/**
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
public class OutputDto {

    @JsonRawValue
    private String gridCleaningResult;

    private LocalDateTime creationDate;

    public void setGridCleaningResult(String gridCleaningResult) {
        this.gridCleaningResult = gridCleaningResult;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }


}
