/**
 * CharacterController.java
 * 
 * Controlador principal que maneja las peticiones HTTP relacionadas con los personajes
 * de Rick and Morty. Proporciona endpoints para:
 * - Listar personajes con paginación y filtrado por nombre
 * - Ver detalles de un personaje específico
 * 
 * Las rutas base son:
 * - GET /characters - Lista de personajes
 * - GET /characters/{id} - Detalles de un personaje
 */

package com.rickmorty.rickmortyapp.controller;

import com.rickmorty.rickmortyapp.model.Character;
import com.rickmorty.rickmortyapp.service.CharacterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/characters")
public class CharacterController {

    private final CharacterService characterService;
    private final int pageSize = 20;  // Tamaño fijo de página para la API

    /**
     * Constructor que inyecta el servicio de personajes necesario.
     * @param characterService Servicio que maneja la lógica de negocio
     */
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    /**
     * Redirige la ruta raíz a la lista de personajes.
     * @return Redirección a la lista de personajes
     */
    @GetMapping("/")
    public String home() {
        return "redirect:/characters";
    }

    /**
     * Endpoint que muestra la lista de personajes con paginación.
     * 
     * @param page Número de página (comienza en 1)
     * @param name Nombre del personaje para filtrar (opcional)
     * @param model Modelo de Spring para pasar datos a la vista
     * @return Nombre de la plantilla Thymeleaf a renderizar
     */
    @GetMapping("/characters")
    public String getCharacters(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(required = false) String name,
            Model model) {
        try {
            // Obtiene los personajes del servicio
            List<Character> characters = characterService.getCharacters(page, pageSize, name);
            
            // Añade los datos al modelo para la vista
            model.addAttribute("characters", characters);
            model.addAttribute("currentPage", page);
            model.addAttribute("name", name);
            return "characters";
        } catch (RuntimeException e) {
            // En caso de error, redirige a la página de error
            model.addAttribute("message", e.getMessage());
            return "error";
        }
    }

    /**
     * Endpoint que muestra los detalles de un personaje específico.
     * 
     * @param id ID del personaje a mostrar
     * @param model Modelo de Spring para pasar datos a la vista
     * @return Nombre de la plantilla Thymeleaf a renderizar
     */
    @GetMapping("/character/{id}")
    public String getCharacter(@PathVariable int id, Model model) {
        try {
            // Obtiene el personaje del servicio
            Character character = characterService.getCharacterById(id);
            model.addAttribute("character", character);
            return "character-detail";
        } catch (RuntimeException e) {
            // En caso de error, redirige a la página de error
            model.addAttribute("message", e.getMessage());
            return "error";
        }
    }

    /**
     * Manejador global de excepciones para este controlador.
     * 
     * @param e Excepción capturada
     * @param model Modelo de Spring para pasar datos a la vista
     * @return Página de error con el mensaje correspondiente
     */
    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, Model model) {
        model.addAttribute("message", "Ha ocurrido un error inesperado: " + e.getMessage());
        return "error";
    }
}
