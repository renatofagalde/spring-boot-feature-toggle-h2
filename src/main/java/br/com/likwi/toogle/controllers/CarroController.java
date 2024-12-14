package br.com.likwi.toogle.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarroController {

    @GetMapping("/carro")
    public String getCarro() {
        return "carro";
    }
}
