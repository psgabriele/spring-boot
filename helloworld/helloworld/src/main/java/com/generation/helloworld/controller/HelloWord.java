package com.generation.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//indica que a classe abaixo é uma classe controladora
@RestController

//serve para a construção dos endpoints da API
@RequestMapping("/hello")
public class HelloWord {
	
	@GetMapping
	public String hello() {
		return "BSM's: Orientação ao Futuro, Responsabilidade Pessoal, Mentalidade de Crescimento, Persistência, Trabalho em Equipe, "
				+ "Atenção aos Detalhes, Proatividade e Comunicação.";
	}
	
}
