package com.andersen.webroomba.mapper;

import com.andersen.webroomba.dto.OutputDto;
import com.andersen.webroomba.entity.Output;

import org.springframework.stereotype.Component;

/**
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
@Component
public class OutputToDtoMapper {


    public OutputDto map(Output output) {
        OutputDto outputDto = new OutputDto();
        outputDto.setGridCleaningResult(output.getResult());
        outputDto.setCreationDate(output.getCreationDate());
        return outputDto;
    }
}
