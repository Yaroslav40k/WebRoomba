package com.andersen.webroomba.service.implemantation;

import com.andersen.webroomba.entity.inner.GridConfiguration;
import com.andersen.webroomba.entity.implementation.InputEntity;
import com.andersen.webroomba.repository.InputRepository;
import com.andersen.webroomba.serializer.ObjectToJsonSerializer;
import com.andersen.webroomba.service.InputService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
@Service
public class InputServiceImpl implements InputService {

    private final InputRepository repository;
    private final ObjectToJsonSerializer serializer;

    public InputServiceImpl(final InputRepository repository, final ObjectToJsonSerializer objectToJsonSerializerImpl) {
        this.repository = repository;
        this.serializer = objectToJsonSerializerImpl;
    }

    @Override
    public InputEntity saveInput(final GridConfiguration configuration) {
        InputEntity input = new InputEntity();
        input.setConfiguration(serializer.serializeObject(configuration));
        input.setCreationDate(LocalDateTime.now());
        return repository.save(input);
    }

    @Override
    public List<InputEntity> getAllInputs() {
        return repository.findAll();
    }


}
