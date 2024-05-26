package com.openpay.marvelapi.consumer.service;

import com.openpay.marvelapi.client.model.dto.CharacterResponse;
import com.openpay.marvelapi.client.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarvelServiceImpl implements MarvelService {

    private final CharacterService characterService;

    @Autowired
    public MarvelServiceImpl(CharacterService characterService) {
        this.characterService = characterService;
    }

    @Override
    public List<CharacterResponse> getCharacters() {
        return characterService.getCharacters();
    }
}
