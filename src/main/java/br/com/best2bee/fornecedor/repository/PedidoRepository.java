package br.com.best2bee.fornecedor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.best2bee.fornecedor.modelo.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
