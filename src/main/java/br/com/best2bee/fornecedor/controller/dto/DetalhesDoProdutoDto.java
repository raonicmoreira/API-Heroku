package br.com.best2bee.fornecedor.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.best2bee.fornecedor.modelo.Produto;

public class DetalhesDoProdutoDto {

	private Long id;
	@NotNull @NotEmpty
	private String nome;
	@NotNull @NotEmpty
	private String descricao;
	@NotNull @NotEmpty
	private Double preco;
	
	public DetalhesDoProdutoDto(Produto produto) {
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.descricao = produto.getDescricao();
		this.preco = produto.getPreco();
	}
	
	

	public DetalhesDoProdutoDto(String nome, String descricao, Double preco) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}



	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}


	public Double getPreco() {
		return preco;
	}
	
	//converte Produtos em uma lista de ProdutoDto
	public static List<DetalhesDoProdutoDto> converte(List<Produto> produtos) {
		return produtos.stream().map(DetalhesDoProdutoDto::new).collect(Collectors.toList());
	}
		
}
