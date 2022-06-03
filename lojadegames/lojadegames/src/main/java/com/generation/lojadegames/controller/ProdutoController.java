package com.generation.lojadegames.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.lojadegames.model.Produto;
import com.generation.lojadegames.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
@CrossOrigin("*")
public class ProdutoController {

	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Produto>> buscaProduto() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> buscaProdutoPorId(@PathVariable long id) {
		return repository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/precoMenor/{precoMenor}")
	public ResponseEntity<List<Produto>> getByPrecoLessThanEqual(@PathVariable double precoMenor) {
		return ResponseEntity.ok(repository.findByPrecoLessThanEqual(precoMenor));
	}
	
	@GetMapping("/precoMaior/{precoMaior}")
	public ResponseEntity<List<Produto>> getByPrecoGreaterThanEqual(@PathVariable double precoMaior) {
		return ResponseEntity.ok(repository.findByPrecoGreaterThanEqual(precoMaior));
	}
	
	@GetMapping("/classificacao/{classificacao}")
	public ResponseEntity<List<Produto>> buscaProdutoPorClassificacao(@PathVariable String classificacao) {
		return ResponseEntity.ok(repository.findAllByClassificacaoContainingIgnoreCase(classificacao));
	}
	
	@GetMapping("/jogo/{jogo}")
	public ResponseEntity<List<Produto>> buscaProdutoPorJogo(@PathVariable String jogo) {
		return ResponseEntity.ok(repository.findAllByJogoContainingIgnoreCase(jogo));
	}
	
	@PostMapping
	public ResponseEntity<Produto> adicionaProduto(@Valid @RequestBody Produto produto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
	}
	
	@PutMapping
	public ResponseEntity<Produto> atualizaProduto(@Valid @RequestBody Produto produto) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(produto));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
