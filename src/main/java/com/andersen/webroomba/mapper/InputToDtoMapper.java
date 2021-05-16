package com.andersen.webroomba.mapper;

import com.andersen.webroomba.dto.InputDto;
import com.andersen.webroomba.entity.Input;
import org.springframework.stereotype.Component;

/**
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
@Component
public class InputToDtoMapper {

    public InputDto map(Input input) {
        InputDto inputDto = new InputDto();
        inputDto.setConfiguration(input.getConfiguration());
        inputDto.setCreationDate(input.getCreationDate());
        return inputDto;
    }


}
