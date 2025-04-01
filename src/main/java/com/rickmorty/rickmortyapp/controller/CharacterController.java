package com.rickmorty.rickmortyapp.controller;

import com.rickmorty.rickmortyapp.model.Character;
import com.rickmorty.rickmortyapp.service.CharacterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CharacterController {

    private final CharacterService characterService;
    private final int pageSize = 20;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/characters";
    }

    @GetMapping("/characters")
    public String getCharacters(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(required = false) String name,
            Model model) {
        try {
            List<Character> characters = characterService.getCharacters(page, pageSize, name);
            model.addAttribute("characters", characters);
            model.addAttribute("currentPage", page);
            model.addAttribute("name", name);
            return "characters";
        } catch (RuntimeException e) {
            model.addAttribute("message", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/character/{id}")
    public String getCharacter(@PathVariable int id, Model model) {
        try {
            Character character = characterService.getCharacterById(id);
            model.addAttribute("character", character);
            return "character-detail";
        } catch (RuntimeException e) {
            model.addAttribute("message", e.getMessage());
            return "error";
        }
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, Model model) {
        model.addAttribute("message", "Ha ocurrido un error inesperado: " + e.getMessage());
        return "error";
    }
}
