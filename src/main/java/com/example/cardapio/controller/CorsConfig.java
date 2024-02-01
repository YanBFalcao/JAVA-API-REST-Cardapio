package com.example.cardapio.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173") // Permitir solicitações do frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Permitir os métodos HTTP desejados
                .allowedHeaders("*"); // Permitir todos os cabeçalhos
    }
}
