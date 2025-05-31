package com.calculadoraPolonesa.controller;

import com.calculadoraPolonesa.service.CalculadoraPolonesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v2")
@CrossOrigin(origins = "*")
public class CalculadoraController {

    @Autowired
    private CalculadoraPolonesaService calculadoraPolonesaService2;

    @GetMapping
    public double evaluate(@RequestParam String expression) {
        return calculadoraPolonesaService2.calculadoraPolonesaService(expression);
    }
}
