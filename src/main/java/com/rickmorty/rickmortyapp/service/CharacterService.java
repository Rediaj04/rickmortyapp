package com.rickmorty.rickmortyapp.service;

import com.rickmorty.rickmortyapp.model.Character;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class CharacterService {

    @Value("${rickandmorty.api.base-url}")
    private String baseUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public List<Character> getCharacters(int page, int pageSize, String name) {
        try {
            String url = UriComponentsBuilder.fromUriString(baseUrl + "/character")
                    .queryParam("page", page)
                    .queryParam("name", name)
                    .build()
                    .toUriString();

            CharacterResponse response = restTemplate.getForObject(url, CharacterResponse.class);
            if (response == null || response.getResults() == null || response.getResults().isEmpty()) {
                throw new RuntimeException("No se encontraron personajes");
            }
            return response.getResults();
        } catch (RestClientException e) {
            throw new RuntimeException("Error al obtener los personajes: " + e.getMessage());
        }
    }

    public Character getCharacterById(int id) {
        try {
            String url = baseUrl + "/character/" + id;
            Character character = restTemplate.getForObject(url, Character.class);
            if (character == null) {
                throw new RuntimeException("No se encontró el personaje con ID: " + id);
            }
            return character;
        } catch (RestClientException e) {
            if (e.getMessage().contains("404")) {
                throw new RuntimeException("No se encontró el personaje con ID: " + id);
            }
            throw new RuntimeException("Error al obtener el personaje: " + e.getMessage());
        }
    }

    private static class CharacterResponse {
        private List<Character> results;

        public List<Character> getResults() { return results; }
    }
}
