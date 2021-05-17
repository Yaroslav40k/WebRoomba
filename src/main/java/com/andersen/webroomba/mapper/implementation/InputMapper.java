package com.andersen.webroomba.mapper.implementation;

import com.andersen.webroomba.dto.InputDto;
import com.andersen.webroomba.entity.implementation.InputEntity;
import com.andersen.webroomba.mapper.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Simple mapper to map Input entity to dto.
 * Helps us to avoid problems with using entities on Controller layer.
 *
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
@Component
public class InputMapper implements Mapper<InputDto, InputEntity> {

    @Override
    public InputDto map(InputEntity input) {
        InputDto inputDto = new InputDto();
        inputDto.setConfiguration(input.getConfiguration());
        inputDto.setCreationDate(input.getCreationDate());
        return inputDto;
    }

    @Override
    public List<InputDto> map(List<InputEntity> inputs) {
        return inputs.stream().map(this::map).collect(Collectors.toList());
    }


}
