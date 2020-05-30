package com.estoque.estoque.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Estoque {
    
    @PostMapping(value = "/")
    public String recebeCompra(){
        System.out.println("Mensagem Recebida");
        return "Mensagem Recebida";
    } 
}