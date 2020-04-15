package br.com.best2bee.fornecedor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.best2bee.fornecedor.controller.dto.ItemDoPedidoDto;
import br.com.best2bee.fornecedor.modelo.ItemPedido;
import br.com.best2bee.fornecedor.modelo.Pedido;
import br.com.best2bee.fornecedor.modelo.Produto;
import br.com.best2bee.fornecedor.repository.PedidoRepository;
import br.com.best2bee.fornecedor.repository.ProdutoRepository;

@Service
public class PedidoService {
	// verificar pq o primeiro elemento não está sendo gravado.

	private static final Logger LOG = LoggerFactory.getLogger(PedidoService.class);
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;

	public Pedido realizaPedido(List<ItemDoPedidoDto> produtos) {

		LOG.info("Pedido sendo processado. ");
		List<ItemPedido> itens = new ArrayList<>();

		for (ItemDoPedidoDto itemDoPedidoDTO : produtos) {
			Optional<Produto> optional = produtoRepository.findById(itemDoPedidoDTO.getIdProduto());
			ItemPedido item = new ItemPedido();
			item.setProduto(optional.get());
			item.setQuantidade(itemDoPedidoDTO.getQuantidade());
			itens.add(item);
		}
		LOG.info("Salvando pedido. ");
		Pedido pedido = new Pedido(itens);
		pedidoRepository.save(pedido);
		return pedido;
		
	}

}