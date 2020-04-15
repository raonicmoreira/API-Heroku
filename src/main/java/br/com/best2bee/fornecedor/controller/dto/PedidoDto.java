package br.com.best2bee.fornecedor.controller.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.best2bee.fornecedor.modelo.ItemPedido;
import br.com.best2bee.fornecedor.modelo.Pedido;

public class PedidoDto {
	
	private Long id;
	List<ItemPedido> itens = new ArrayList<>();
	
	public PedidoDto(Pedido pedido) {
		this.id = pedido.getId();
		this.itens = pedido.getItensPedido();
	}
	
	public Long getId() {
		return id;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}
	
	

	
}
