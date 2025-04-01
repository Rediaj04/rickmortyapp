package com.rickmorty.rickmortyapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Character {
    @JsonProperty("id")
    private Integer id;
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("status")
    private String status;
    
    @JsonProperty("species")
    private String species;
    
    @JsonProperty("type")
    private String type;
    
    @JsonProperty("gender")
    private String gender;
    
    @JsonProperty("origin")
    private Location origin;
    
    @JsonProperty("location")
    private Location location;
    
    @JsonProperty("image")
    private String image;
    
    @JsonProperty("episode")
    private List<String> episode;
    
    @JsonProperty("url")
    private String url;
    
    @JsonProperty("created")
    private String created;

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
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
