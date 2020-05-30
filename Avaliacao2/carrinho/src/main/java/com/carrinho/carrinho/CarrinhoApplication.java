package com.carrinho.carrinho;

import com.carrinho.carrinho.controller.FinalizarCarrinho;
import com.carrinho.carrinho.model.Carrinho;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarrinhoApplication {

	public static void main(String[] args) {
		String[] skus = {"001","002","003"};
		String email = "jcas@cesar.school";
		String cep = "512072927";
		Double valor = 120.20;

		String urlCobranca = "http://localhost:8081";
		String urlEstoque = "http://localhost:8082";
		String urlExpedicao = "http://localhost:8083";

		Carrinho carrinho = new Carrinho(email, cep, skus, valor);

		FinalizarCarrinho pedido = new FinalizarCarrinho();

		pedido.finalizarCarrinho(carrinho, urlCobranca);
		pedido.finalizarCarrinho(carrinho, urlEstoque);
		pedido.finalizarCarrinho(carrinho, urlExpedicao);
	}
}
