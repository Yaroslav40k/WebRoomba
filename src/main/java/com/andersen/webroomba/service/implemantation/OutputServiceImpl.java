package com.andersen.webroomba.service.implemantation;

import com.andersen.webroomba.entity.inner.GridCleaningResult;
import com.andersen.webroomba.entity.implementation.InputEntity;
import com.andersen.webroomba.entity.implementation.OutputEntity;
import com.andersen.webroomba.repository.OutputRepository;
import com.andersen.webroomba.serializer.ObjectToJsonSerializer;
import com.andersen.webroomba.service.OutputService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
@Service
public class OutputServiceImpl implements OutputService {

    private final OutputRepository repository;
    private final ObjectToJsonSerializer serializer;

    public OutputServiceImpl(final OutputRepository repository, final ObjectToJsonSerializer objectToJsonSerializerImpl) {
        this.repository = repository;
        this.serializer = objectToJsonSerializerImpl;
    }

    @Override
    public OutputEntity saveOutput(final InputEntity input, final GridCleaningResult gridCleaningResult) {
        OutputEntity output = new OutputEntity();
        output.setInput(input);
        output.setResult(serializer.serializeObject(gridCleaningResult));
        output.setCreationDate(LocalDateTime.now());
        return repository.save(output);
    }

    @Override
    public List<OutputEntity> getAllOutputs() {
        return repository.findAll();
    }

}
