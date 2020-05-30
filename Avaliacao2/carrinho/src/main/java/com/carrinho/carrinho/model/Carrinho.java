package com.carrinho.carrinho.model;

public class Carrinho {
    
    public String email;
    public String cep;
    public String [] skus;
    public Double valor;

    
    public Carrinho(String email, String cep, String [] skus, Double valor) {
        this.email = email;
        this.cep = cep;
        this.skus = skus;
        this.valor = valor;
    }
    
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String[] getSkus() {
        return skus;
    }

    public void setSkus(String[] skus) {
        this.skus = skus;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}