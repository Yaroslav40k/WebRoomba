package com.andersen.webroomba;

import com.andersen.webroomba.entity.GridCleaningResult;
import com.andersen.webroomba.entity.Input;
import com.andersen.webroomba.entity.Output;
import com.andersen.webroomba.repository.OutputRepository;
import com.andersen.webroomba.serializer.ObjectToJsonSerializer;
import com.andersen.webroomba.service.implemantation.OutputServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.AdditionalAnswers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * @author Yaroslav Dmitriev (
 * @since 16.05.2021
 */
@ExtendWith(MockitoExtension.class)
class OutputServiceImplTest {

    private OutputServiceImpl outputService;

    @Mock
    private OutputRepository repository;
    @Mock
    private ObjectToJsonSerializer serializer;

    @BeforeEach
    void setUp() {
        outputService = new OutputServiceImpl(repository, serializer);
    }

    @ParameterizedTest
    @ValueSource(strings = {"{\"coords\" : [1, 3],\"patches\" : 1}"})
    void saveOutput_withValidConfiguration_expectingCreatedOutput(String serializedOutput) {
        when(serializer.serializeObject(any(GridCleaningResult.class))).thenReturn(serializedOutput);
        when(repository.save(any(Output.class))).then(AdditionalAnswers.returnsFirstArg());

        Input suspiciousInput = new Input();
        GridCleaningResult suspiciousResult = new GridCleaningResult();
        suspiciousResult.setCoords(new int[] {1, 3});
        suspiciousResult.setPatches(1);

        outputService.saveOutput(suspiciousInput,suspiciousResult);

        verify(serializer, times(1)).serializeObject(any(GridCleaningResult.class));
        verify(repository, times(1)).save(any(Output.class));
    }

    @Test
    void getAllOutputs_expectingListOfInputs() {
        when(repository.findAll()).thenReturn(List.of(new Output()));

        outputService.getAllOutputs();

        verify(repository, times(1)).findAll();
    }


}
