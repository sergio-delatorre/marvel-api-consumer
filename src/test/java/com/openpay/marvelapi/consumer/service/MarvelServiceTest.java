package com.openpay.marvelapi.consumer.service;

import com.openpay.marvelapi.client.model.dto.CharacterResponse;
import com.openpay.marvelapi.client.service.CharacterService;
import com.openpay.marvelapi.consumer.model.entity.ServiceRequestLog;
import com.openpay.marvelapi.consumer.repository.ServiceRequestLogRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class MarvelServiceTest {

    @InjectMocks
    private MarvelServiceImpl marvelService;
    @Mock
    private CharacterService characterService;
    @Mock
    private ServiceRequestLogRepository repository;

    @Test
    public void testGetCharacters_Success() {
        List<CharacterResponse> mockCharacterResponses = Collections.singletonList(new CharacterResponse());
        Mockito.when(characterService.getCharacters()).thenReturn(mockCharacterResponses);

        List<CharacterResponse> characterResponses = marvelService.getCharacters();

        Assertions.assertEquals(mockCharacterResponses, characterResponses);
        Mockito.verify(repository).save(Mockito.any(ServiceRequestLog.class));
        Mockito.verify(characterService).getCharacters();
    }

    @Test
    public void testGetCharacterById_Success() {
        Long characterId = 1L;
        CharacterResponse mockCharacterResponse = new CharacterResponse();
        Mockito.when(characterService.getCharacterById(characterId)).thenReturn(mockCharacterResponse);

        CharacterResponse characterResponse = marvelService.getCharacterById(characterId);

        Assertions.assertEquals(mockCharacterResponse, characterResponse);
        Mockito.verify(repository).save(Mockito.any(ServiceRequestLog.class));
        Mockito.verify(characterService).getCharacterById(characterId);
    }
}
