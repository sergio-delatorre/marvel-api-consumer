package com.openpay.marvelapi.consumer.controller;

import com.openpay.marvelapi.client.model.dto.CharacterResponse;
import com.openpay.marvelapi.consumer.service.MarvelService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/marvel/characters")
@Api(tags = "Characters")
public class CharacterController {

    private final MarvelService marvelService;

    @Autowired
    public CharacterController(MarvelService marvelService) {
        this.marvelService = marvelService;
    }

    @GetMapping()
    public List<CharacterResponse> getCharacters() {
        return marvelService.getCharacters();
    }

    @GetMapping("/{characterId}")
    public CharacterResponse getCharacterById(@PathVariable @NotNull @Positive Long characterId) {
        return marvelService.getCharacterById(characterId);
    }

}
