package com.andersen.webroomba;

import com.andersen.webroomba.entity.GridConfiguration;
import com.andersen.webroomba.entity.Input;
import com.andersen.webroomba.repository.InputRepository;
import com.andersen.webroomba.serializer.ObjectToJsonSerializer;
import com.andersen.webroomba.service.implemantation.InputServiceImpl;
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
class InputServiceImplTest {

    private InputServiceImpl inputService;

    @Mock private InputRepository repository;
    @Mock private ObjectToJsonSerializer serializer;

    @BeforeEach
    void setUp() {
        inputService = new InputServiceImpl(repository, serializer);
    }

    @ParameterizedTest
    @ValueSource(strings = {"{\"roomSize\": [5,5],\"coords\": [1,1],\"patches\": [[0,2]],\"instructions\": \"WNES\"}"})
    void saveInput_withValidConfiguration_expectingCreatedInput(String serializedInput) {
        when(serializer.serializeObject(any(GridConfiguration.class))).thenReturn(serializedInput);
        when(repository.save(any(Input.class))).then(AdditionalAnswers.returnsFirstArg());

        GridConfiguration suspiciousConfiguration = new GridConfiguration();
        suspiciousConfiguration.setRoomSize(new int[]{5,5});
        suspiciousConfiguration.setCoords(new int[]{1,1});
        suspiciousConfiguration.setPatches(List.of(new int[]{0,2}));
        suspiciousConfiguration.setInstructions("WNES");

        inputService.saveInput(suspiciousConfiguration);

        verify(serializer, times(1)).serializeObject(any(GridConfiguration.class));
        verify(repository, times(1)).save(any(Input.class));
    }

    @Test
    void getAllInputs_expectingListOfInputs () {
        when(repository.findAll()).thenReturn(List.of(new Input()));

        inputService.getAllInputs();

        verify(repository, times(1)).findAll();
    }


}
