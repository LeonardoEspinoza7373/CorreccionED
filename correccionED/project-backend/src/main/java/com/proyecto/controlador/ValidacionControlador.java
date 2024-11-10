package com.proyecto.controlador;

import com.proyecto.servicio.ValidacionService;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/validacion")
public class ValidacionControlador {

    private final ValidacionService validacionService;

    // Constructor 
    public ValidacionControlador(ValidacionService validacionService) {
        this.validacionService = validacionService;
    }

    // Endpoint 
    @PostMapping("/validar")
    public Map<String, String> validarHtml(@RequestBody String html) {
        // Llama al servicio de validación y verifica si el HTML es válido
        boolean esValido = validacionService.validarHtml(html);

        // Crea una respuesta en formato JSON
        Map<String, String> response = new HashMap<>();
        response.put("resultado", esValido ? "El código HTML es válido." : "El código HTML es inválido.");

        return response; 
    }
}
