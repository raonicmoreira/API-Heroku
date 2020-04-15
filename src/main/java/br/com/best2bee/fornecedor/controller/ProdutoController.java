package br.com.best2bee.fornecedor.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.best2bee.fornecedor.controller.dto.DetalhesDoProdutoDto;
import br.com.best2bee.fornecedor.controller.dto.ProdutoDto;
import br.com.best2bee.fornecedor.modelo.Produto;
import br.com.best2bee.fornecedor.repository.ProdutoRepository;
import br.com.best2bee.fornecedor.service.PedidoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	private static final Logger LOG = LoggerFactory.getLogger(PedidoService.class);
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping
	public List<ProdutoDto> lista(){
		LOG.info("Buscando lista de produtos. ");
		List<Produto> produtos = produtoRepository.findAll();
		LOG.info("Lista de produtos processada.");
		return ProdutoDto.converter(produtos);
	}
	
	
	@GetMapping("/{nome}")
	public ResponseEntity<DetalhesDoProdutoDto> detalhar(@PathVariable String nome) {
		LOG.info("Recebido o nome do produto para busca.");
		Produto produto = produtoRepository.findByNome(nome);
		
		
		if(produto != null) {
			LOG.info("Retornando produto encontrado.");
			return ResponseEntity.ok(new DetalhesDoProdutoDto(produto));
		}
		LOG.info("Produto não encontrado.");
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<ProdutoDto> CadastrarProduto(@RequestBody @Valid Produto produto, 
														UriComponentsBuilder uriBuilder) {
		produtoRepository.save(produto);
		LOG.info("Produto cadastrado com sucesso. ");
		URI uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProdutoDto(produto));
	}
}

