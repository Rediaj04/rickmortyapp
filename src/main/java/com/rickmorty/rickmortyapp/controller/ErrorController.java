package com.rickmorty.rickmortyapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorController {

    @GetMapping
    public String handleError(Model model) {
        model.addAttribute("message", "Lo sentimos, no pudimos encontrar lo que buscas. ¿Quizás intentaste buscar un personaje que no existe?");
        return "error";
    }
} 