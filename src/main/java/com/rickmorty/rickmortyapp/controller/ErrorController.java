/**
 * ErrorController.java
 * 
 * Controlador que maneja las páginas de error personalizadas de la aplicación.
 * Se encarga de mostrar mensajes de error amigables al usuario cuando ocurre
 * algún problema durante la ejecución.
 */

package com.rickmorty.rickmortyapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

    /**
     * Endpoint que muestra la página de error genérica.
     * Se utiliza cuando ocurre cualquier error no manejado específicamente.
     * 
     * @param model Modelo de Spring para pasar datos a la vista
     * @return Nombre de la plantilla de error a renderizar
     */
    @GetMapping("/error")
    public String handleError(Model model) {
        model.addAttribute("message", "Ha ocurrido un error inesperado");
        return "error";
    }
} 