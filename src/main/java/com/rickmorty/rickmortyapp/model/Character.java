/**
 * Character.java
 * 
 * Modelo que representa un personaje de la serie Rick and Morty.
 * Esta clase mapea la estructura de datos que devuelve la API de Rick and Morty
 * para un personaje individual.
 * 
 * Utiliza anotaciones de Jackson para el mapeo JSON y Lombok para generar
 * automáticamente los métodos getter, setter, toString, etc.
 */

package com.rickmorty.rickmortyapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
public class Character {
    @JsonProperty("id")
    private Long id;           // Identificador único del personaje en la API

    @JsonProperty("name")
    private String name;       // Nombre completo del personaje

    @JsonProperty("status")
    private String status;     // Estado del personaje (Alive, Dead, unknown)

    @JsonProperty("species")
    private String species;    // Especie del personaje (Human, Alien, etc.)

    @JsonProperty("type")
    private String type;       // Tipo específico o subespecie del personaje

    @JsonProperty("gender")
    private String gender;     // Género del personaje (Male, Female, Genderless, unknown)

    @JsonProperty("origin")
    private Location origin;   // Lugar de origen del personaje

    @JsonProperty("location")
    private Location location; // Ubicación actual del personaje

    @JsonProperty("image")
    private String image;      // URL de la imagen del personaje

    @JsonProperty("episode")
    private List<String> episode; // Lista de URLs de los episodios en los que aparece

    @JsonProperty("url")
    private String url;        // URL del personaje en la API

    @JsonProperty("created")
    private String created;    // Fecha de creación del personaje en la API

    // Getters y Setters
    public Integer getId() { return id.intValue(); }
    public void setId(Integer id) { this.id = id.longValue(); }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public String getSpecies() { return species; }
    public void setSpecies(String species) { this.species = species; }
    
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    
    public Location getOrigin() { return origin; }
    public void setOrigin(Location origin) { this.origin = origin; }
    
    public Location getLocation() { return location; }
    public void setLocation(Location location) { this.location = location; }
    
    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
    
    public List<String> getEpisode() { return episode; }
    public void setEpisode(List<String> episode) { this.episode = episode; }
    
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    
    public String getCreated() { return created; }
    public void setCreated(String created) { this.created = created; }
}
