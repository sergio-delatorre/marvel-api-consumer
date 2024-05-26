package com.openpay.marvelapi.consumer.service;

import com.openpay.marvelapi.client.model.dto.CharacterResponse;
import com.openpay.marvelapi.client.service.CharacterService;
import com.openpay.marvelapi.client.util.MarvelApiConstants;
import com.openpay.marvelapi.consumer.model.entity.ServiceRequestLog;
import com.openpay.marvelapi.consumer.repository.ServiceRequestLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarvelServiceImpl implements MarvelService {

    private final CharacterService characterService;
    private final ServiceRequestLogRepository serviceRequestLogRepository;

    @Autowired
    public MarvelServiceImpl(CharacterService characterService, ServiceRequestLogRepository serviceRequestLogRepository) {
        this.characterService = characterService;
        this.serviceRequestLogRepository = serviceRequestLogRepository;
    }

    @Override
    public List<CharacterResponse> getCharacters() {
        ServiceRequestLog serviceRequestLog = new ServiceRequestLog();
        serviceRequestLog.setPath(MarvelApiConstants.CHARACTERS_URI);
        serviceRequestLogRepository.save(serviceRequestLog);
        return characterService.getCharacters();
    }
}
