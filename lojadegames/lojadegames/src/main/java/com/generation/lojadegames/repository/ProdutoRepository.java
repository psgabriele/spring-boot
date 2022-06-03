package com.generation.lojadegames.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.lojadegames.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	public List<Produto> findAllByJogoContainingIgnoreCase (String jogo);

	public List<Produto> findByPrecoLessThanEqual(double preco);
	
	public List<Produto> findByPrecoGreaterThanEqual(double preco);
	
	public List<Produto> findAllByClassificacaoContainingIgnoreCase(String classificacao);

	
}
