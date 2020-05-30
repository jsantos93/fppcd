package com.cobranca.cobranca.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Cobranca {
    
    @PostMapping(value = "/")
    public String recebeCobranca(){
        System.out.println("Mensagem Recebida");
        return "Mensagem Recebida";
    } 
}