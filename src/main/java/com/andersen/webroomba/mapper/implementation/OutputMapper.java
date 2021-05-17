package com.andersen.webroomba.mapper.implementation;

import com.andersen.webroomba.dto.OutputDto;
import com.andersen.webroomba.entity.implementation.OutputEntity;
import com.andersen.webroomba.mapper.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Simple mapper to map Output entity to dto.
 * Helps us to avoid problems with using entities on Controller layer.
 *
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
@Component
public class OutputMapper implements Mapper<OutputDto, OutputEntity> {

    @Override
    public OutputDto map(OutputEntity output) {
        OutputDto outputDto = new OutputDto();
        outputDto.setGridCleaningResult(output.getResult());
        outputDto.setCreationDate(output.getCreationDate());
        return outputDto;
    }

    @Override
    public List<OutputDto> map(List<OutputEntity> outputs) {
        return outputs.stream().map(this::map).collect(Collectors.toList());
    }


}
