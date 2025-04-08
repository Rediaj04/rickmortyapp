/**
 * RestTemplateConfig.java
 * 
 * Configuración del cliente HTTP RestTemplate utilizado para realizar
 * las llamadas a la API externa de Rick and Morty.
 * 
 * Esta clase de configuración:
 * - Crea un bean de RestTemplate para ser inyectado en otros componentes
 * - Permite personalizar la configuración del cliente HTTP si es necesario
 * - Centraliza la configuración de las llamadas HTTP en un solo lugar
 */

package com.rickmorty.rickmortyapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration  // Indica que esta clase proporciona configuración de beans
public class RestTemplateConfig {

    /**
     * Crea y configura una instancia de RestTemplate para realizar
     * llamadas HTTP a la API de Rick and Morty.
     * 
     * @return Una instancia configurada de RestTemplate
     */
    @Bean  // Marca este método como proveedor de un bean para Spring
    public RestTemplate restTemplate() {
        return new RestTemplate();  // Por ahora usa la configuración por defecto
    }
} 