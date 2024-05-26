package com.openpay.marvelapi.consumer.controller;

import com.openpay.marvelapi.client.model.dto.CharacterResponse;
import com.openpay.marvelapi.consumer.security.JwtTokenProvider;
import com.openpay.marvelapi.consumer.service.MarvelService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class CharacterControllerTest {

    private static final String CHARACTER_PATH = "/marvel/characters";

    @Autowired
    private MockMvc mockMvc;
    @Mock
    private MarvelService marvelService;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Test
    public void testGetCharacters_Success() throws Exception {
        List<CharacterResponse> mockCharacterResponses = Collections.singletonList(new CharacterResponse());
        Mockito.when(marvelService.getCharacters()).thenReturn(mockCharacterResponses);

        mockMvc.perform(get(CHARACTER_PATH)
                        .header("Authorization", "Bearer " + jwtTokenProvider.generateToken()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(Matchers.greaterThan(0))));
    }

    @Test
    public void testGetCharacters_Forbidden() throws Exception {
        List<CharacterResponse> mockCharacterResponses = Collections.singletonList(new CharacterResponse());
        Mockito.when(marvelService.getCharacters()).thenReturn(mockCharacterResponses);

        mockMvc.perform(get(CHARACTER_PATH))
                .andExpect(status().isForbidden());
    }

    @Test
    public void testGetCharacterById_Success() throws Exception {
        Long characterId = 1017100L;
        CharacterResponse mockCharacterResponse = new CharacterResponse();
        Mockito.when(marvelService.getCharacterById(characterId)).thenReturn(mockCharacterResponse);

        mockMvc.perform(get(CHARACTER_PATH+"/{characterId}", characterId)
                        .header("Authorization", "Bearer " + jwtTokenProvider.generateToken()))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetCharacterById_Forbidden() throws Exception {
        Long characterId = 1017100L;
        CharacterResponse mockCharacterResponse = new CharacterResponse();
        Mockito.when(marvelService.getCharacterById(characterId)).thenReturn(mockCharacterResponse);

        mockMvc.perform(get(CHARACTER_PATH+"/{characterId}", characterId))
                .andExpect(status().isForbidden());
    }
}
