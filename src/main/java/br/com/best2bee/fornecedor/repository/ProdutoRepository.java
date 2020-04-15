package br.com.best2bee.fornecedor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.best2bee.fornecedor.modelo.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	Produto findByNome(String nome);
	List<Produto> findByIdIn(List<Long> ids);

}
