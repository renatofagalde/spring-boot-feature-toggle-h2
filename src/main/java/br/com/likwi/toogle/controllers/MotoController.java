package br.com.likwi.toogle.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MotoController {

    @GetMapping("/moto")
    public String getMoto() {
        return "moto";
    }
}
