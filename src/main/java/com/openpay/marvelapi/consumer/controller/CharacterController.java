package com.openpay.marvelapi.consumer.controller;

import com.openpay.marvelapi.client.model.dto.CharacterResponse;
import com.openpay.marvelapi.consumer.service.MarvelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

/**
 * Controlador REST para manejar solicitudes relacionadas con los personajes de Marvel.
 * <p>
 * Incluye los siguientes endpoints
 * <ul>
 * 	<li> Obtener lista de personajes
 * 	<li> Obtener personaje por Id
 * </ul>
 *
 * @author Sergio de la Torre
 * @see CharacterResponse
 * @see MarvelService
 * @version 1.0
 * @since 2024-05-26
 */
@RestController
@RequestMapping("/marvel/characters")
@Api(tags = "Characters")
public class CharacterController {

    private final MarvelService marvelService;

    @Autowired
    public CharacterController(MarvelService marvelService) {
        this.marvelService = marvelService;
    }

    /**
     * Endpoint para obtener la lista de personajes de Marvel.
     *
     * @return Una lista de objetos {@link CharacterResponse} que representan los personajes de Marvel.
     */
    @GetMapping()
    @ApiOperation(value = "Get list of characters", notes = "Returns the entire list of Marvel characters")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    public List<CharacterResponse> getCharacters() {
        return marvelService.getCharacters();
    }

    /**
     * Endpoint para obtener los detalles de un personaje específico de Marvel por su ID.
     *
     * @param characterId El ID del personaje que se desea obtener. Debe ser un valor positivo y no nulo.
     * @return Un objeto {@link CharacterResponse} que representa el personaje de Marvel con el ID especificado.
     */
    @ApiOperation(value = "Get character by ID", notes = "Returns a Marvel character based on ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved character"),
            @ApiResponse(code = 400, message = "Invalid character ID"),
            @ApiResponse(code = 404, message = "Character not found"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @GetMapping("/{characterId}")
    public CharacterResponse getCharacterById(@PathVariable @NotNull @Positive Long characterId) {
        return marvelService.getCharacterById(characterId);
    }

}
