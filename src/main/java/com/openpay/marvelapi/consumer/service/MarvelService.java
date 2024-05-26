package com.openpay.marvelapi.consumer.service;

import com.openpay.marvelapi.client.model.dto.CharacterResponse;

import java.util.List;

public interface MarvelService {

    List<CharacterResponse> getCharacters();

    CharacterResponse getCharacterById(Long id);

}
