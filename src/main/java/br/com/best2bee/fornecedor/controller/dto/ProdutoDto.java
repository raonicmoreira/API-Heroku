package br.com.best2bee.fornecedor.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.best2bee.fornecedor.modelo.Produto;

//CLass criada para enviar as informações.
public class ProdutoDto {
	
	private Long id;
	private String nome;
	private Double preco;
	
	public ProdutoDto(Produto produto) {
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.preco = produto.getPreco();
	}
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public Double getPreco() {
		return preco;
	}
	
	//converte Produto em uma lista de ProdutoDto
	public static List<ProdutoDto> converter(List<Produto> produtos) {
		return produtos.stream().map(ProdutoDto::new).collect(Collectors.toList());
	//	return produtos.stream().map(ProdutoDto::new).collect(Collectors.toList());
	}
	
	

}
