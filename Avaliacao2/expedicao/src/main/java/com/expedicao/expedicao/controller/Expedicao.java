package com.expedicao.expedicao.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Expedicao {
    
    @PostMapping(value = "/")
    public String recebeCobranca(){
        System.out.println("Mensagem Recebida");
        return "Mensagem Recebida";
    } 
}