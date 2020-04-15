package br.com.best2bee.fornecedor.controller.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ItemDoPedidoDto {
	@NotNull @NotEmpty
	private long idProduto;
	@NotNull @NotEmpty
	private int quantidade;


	public long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(long idProduto) {
		this.idProduto = idProduto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}
