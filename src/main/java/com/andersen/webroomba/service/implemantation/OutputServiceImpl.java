package com.andersen.webroomba.service.implemantation;

import com.andersen.webroomba.entity.GridCleaningResult;
import com.andersen.webroomba.entity.Input;
import com.andersen.webroomba.entity.Output;
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

    public OutputServiceImpl(OutputRepository repository, ObjectToJsonSerializer serializer) {
        this.repository = repository;
        this.serializer = serializer;
    }

    @Override
    public Output saveOutput(Input input, GridCleaningResult gridCleaningResult) {
        Output output = new Output();
        output.setInput(input);
        output.setResult(serializer.serializeObject(gridCleaningResult));
        output.setCreationDate(LocalDateTime.now());
        return repository.save(output);
    }

    @Override
    public List<Output> getAllOutputs() {
        return repository.findAll();
    }

}
