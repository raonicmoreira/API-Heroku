package br.com.best2bee.fornecedor.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.best2bee.fornecedor.controller.dto.ItemDoPedidoDto;
import br.com.best2bee.fornecedor.controller.dto.PedidoDto;
import br.com.best2bee.fornecedor.modelo.Pedido;
import br.com.best2bee.fornecedor.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

	private static final Logger LOG = LoggerFactory.getLogger(PedidoService.class);
	
	@Autowired
	private PedidoService pedidoService;
	
	@PostMapping
	public ResponseEntity<PedidoDto> realizaPedido(@RequestBody @Valid List<ItemDoPedidoDto> produtos, UriComponentsBuilder uriBuilder) {
		Pedido pedido = new Pedido();
		try {
			LOG.info("Recebida a lista de produtos para processamento do pedido. ");
			pedido = pedidoService.realizaPedido(produtos);
		} catch (Exception e) {
			LOG.info("Produto não encontrado. ");
			return ResponseEntity.notFound().build();
		}
		LOG.info("Pedido realizado com sucesso. ");
		URI uri = uriBuilder.path("/pedido/{id}").buildAndExpand(pedido.getId()).toUri();
		return ResponseEntity.created(uri).body(new PedidoDto(pedido));
	}
	
	
}
