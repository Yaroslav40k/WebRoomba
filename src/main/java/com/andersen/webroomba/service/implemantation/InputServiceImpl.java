package com.andersen.webroomba.service.implemantation;

import com.andersen.webroomba.entity.GridConfiguration;
import com.andersen.webroomba.entity.Input;
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

    public InputServiceImpl(InputRepository repository, ObjectToJsonSerializer serializer) {
        this.repository = repository;
        this.serializer = serializer;
    }

    @Override
    public Input saveInput(GridConfiguration configuration) {
        Input input = new Input();
        input.setConfiguration(serializer.serializeObject(configuration));
        input.setCreationDate(LocalDateTime.now());
        return repository.save(input);
    }

    @Override
    public List<Input> getAllInputs() {
        return repository.findAll();
    }


}
