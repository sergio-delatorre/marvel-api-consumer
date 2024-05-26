package com.openpay.marvelapi.consumer.service;

import com.openpay.marvelapi.client.model.dto.CharacterResponse;

import java.util.List;

/**
 * Interfaz que define los métodos asociados a obtener información desde el Marvel API Client.
 *
 * @author Sergio de la Torre
 * @see CharacterResponse
 * @version 1.0
 * @since 2024-05-26
 */
public interface MarvelService {

    /**
     * Obtiene una lista de personajes de Marvel.
     *
     * @return Una lista de objetos {@link CharacterResponse} que representan los personajes de Marvel.
     */
    List<CharacterResponse> getCharacters();

    /**
     * Obtiene los detalles de un personaje específico de Marvel por su ID.
     *
     * @param id El ID del personaje que se desea obtener.
     * @return Un objeto {@link CharacterResponse} que representa el personaje de Marvel con el ID especificado.
     */
    CharacterResponse getCharacterById(Long id);

}
