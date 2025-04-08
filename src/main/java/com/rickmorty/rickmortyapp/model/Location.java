/**
 * Location.java
 * 
 * Modelo que representa una ubicación en el universo de Rick and Morty.
 * Se utiliza para mapear tanto el lugar de origen como la ubicación actual
 * de un personaje.
 */

package com.rickmorty.rickmortyapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Location {
    @JsonProperty("name")
    private String name;       // Nombre de la ubicación

    @JsonProperty("url")
    private String url;        // URL de la ubicación en la API

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
} 