package com.openpay.marvelapi.consumer.service;

import com.openpay.marvelapi.client.model.dto.CharacterResponse;
import com.openpay.marvelapi.client.service.CharacterService;
import com.openpay.marvelapi.client.util.MarvelApiConstants;
import com.openpay.marvelapi.consumer.model.entity.RequestLog;
import com.openpay.marvelapi.consumer.repository.RequestLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarvelServiceImpl implements MarvelService {

    private final CharacterService characterService;
    private final RequestLogRepository requestLogRepository;

    @Autowired
    public MarvelServiceImpl(CharacterService characterService, RequestLogRepository requestLogRepository) {
        this.characterService = characterService;
        this.requestLogRepository = requestLogRepository;
    }

    @Override
    public List<CharacterResponse> getCharacters() {
        RequestLog requestLog = new RequestLog();
        requestLog.setPath(MarvelApiConstants.CHARACTERS_URI);
        requestLogRepository.save(requestLog);
        return characterService.getCharacters();
    }

    @Override
    public CharacterResponse getCharacterById(Long characterId) {
        RequestLog requestLog = new RequestLog();
        requestLog.setPath(MarvelApiConstants.CHARACTERS_URI+"/"+characterId);
        requestLogRepository.save(requestLog);
        return characterService.getCharacterById(characterId);
    }
}
