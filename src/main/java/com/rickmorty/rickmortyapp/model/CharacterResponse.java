/**
 * CharacterResponse.java
 * 
 * Modelo que representa la respuesta de la API de Rick and Morty
 * cuando se solicita una lista de personajes.
 * 
 * Esta clase contiene tanto la lista de personajes como la información
 * de paginación necesaria para navegar entre los resultados.
 */

package com.rickmorty.rickmortyapp.model;

import lombok.Data;
import java.util.List;

@Data
public class CharacterResponse {
    // Información sobre la paginación y el total de resultados
    private Info info;
    
    // Lista de personajes devueltos en la página actual
    private List<Character> results;

    /**
     * Clase interna que contiene la información de paginación
     */
    @Data
    public static class Info {
        private int count;    // Número total de personajes
        private int pages;    // Número total de páginas
        private String next;  // URL de la siguiente página (null si no hay más)
        private String prev;  // URL de la página anterior (null si es la primera)
    }
} 