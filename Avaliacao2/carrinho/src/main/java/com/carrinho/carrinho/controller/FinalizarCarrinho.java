package com.carrinho.carrinho.controller;

import com.carrinho.carrinho.model.Carrinho;
import org.springframework.http.ResponseEntity;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class FinalizarCarrinho {
    public String finalizarCarrinho(Carrinho carrinho,String url) {
        
        RestTemplate restTemplate = new RestTemplate();


        Map<String, Object> map = new HashMap<>();
        map.put("email", carrinho.getEmail());
        map.put("CEP", carrinho.getCep());
        map.put("valor", carrinho.getValor());
        map.put("skus", carrinho.getSkus());
        ResponseEntity<Void> response = restTemplate.postForEntity(url, map, Void.class);


        if (response.getStatusCode() == HttpStatus.OK) {
            return "Request Successful";
        } else {
            return "Request Failed";
        }
    }
}