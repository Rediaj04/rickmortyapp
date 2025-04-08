/**
 * CharacterService.java
 * 
 * Este servicio se encarga de la comunicación con la API de Rick and Morty.
 * Proporciona métodos para obtener personajes de la serie, ya sea en lista paginada
 * o individualmente por su ID.
 * 
 * Utiliza RestTemplate para realizar las peticiones HTTP a la API externa y
 * maneja los errores que puedan ocurrir durante la comunicación.
 */

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

    // URL base de la API de Rick and Morty, configurada en application.properties
    @Value("${rickandmorty.api.base-url}")
    private String baseUrl;

    // Cliente HTTP para realizar las peticiones a la API
    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * Obtiene una lista paginada de personajes, opcionalmente filtrada por nombre.
     * @param page Número de página (comienza en 1)
     * @param pageSize Tamaño de la página
     * @param name Nombre del personaje a buscar (opcional)
     * @return Lista de personajes que coinciden con los criterios de búsqueda
     * @throws RuntimeException Si no se encuentran personajes o hay un error en la comunicación
     */
    public List<Character> getCharacters(int page, int pageSize, String name) {
        try {
            // Construye la URL con los parámetros de paginación y búsqueda
            String url = UriComponentsBuilder.fromUriString(baseUrl + "/character")
                    .queryParam("page", page)
                    .queryParam("name", name)
                    .build()
                    .toUriString();

            // Realiza la petición GET a la API
            CharacterResponse response = restTemplate.getForObject(url, CharacterResponse.class);
            
            // Verifica si se encontraron resultados
            if (response == null || response.getResults() == null || response.getResults().isEmpty()) {
                throw new RuntimeException("No se encontraron personajes");
            }
            return response.getResults();
        } catch (RestClientException e) {
            throw new RuntimeException("Error al obtener los personajes: " + e.getMessage());
        }
    }

    /**
     * Obtiene un personaje específico por su ID.
     * @param id ID del personaje a buscar
     * @return El personaje encontrado
     * @throws RuntimeException Si el personaje no existe o hay un error en la comunicación
     */
    public Character getCharacterById(int id) {
        try {
            // Construye la URL para obtener un personaje específico
            String url = baseUrl + "/character/" + id;
            
            // Realiza la petición GET a la API
            Character character = restTemplate.getForObject(url, Character.class);
            
            // Verifica si se encontró el personaje
            if (character == null) {
                throw new RuntimeException("No se encontró el personaje con ID: " + id);
            }
            return character;
        } catch (RestClientException e) {
            // Maneja específicamente el caso de personaje no encontrado (404)
            if (e.getMessage().contains("404")) {
                throw new RuntimeException("No se encontró el personaje con ID: " + id);
            }
            throw new RuntimeException("Error al obtener el personaje: " + e.getMessage());
        }
    }

    /**
     * Clase interna para mapear la respuesta de la API cuando se obtiene una lista de personajes.
     * Contiene los resultados y metadatos de la paginación.
     */
    private static class CharacterResponse {
        private List<Character> results;

        public List<Character> getResults() { return results; }
    }
}
