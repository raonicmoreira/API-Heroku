package br.com.best2bee.fornecedor.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Pedido {

	
	@Id 
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name= "increment", strategy =  "increment")
	private Long id;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="pedidoId")
	private List<ItemPedido> itens = new ArrayList<>();
	
	
	public Pedido() {
	}

	public Pedido(List<ItemPedido> itens) {
		super();
		this.itens = itens;
	}


	
	@Override
	public String toString() {
		return "Pedido [id=" + id + ", itens=" + itens + "]";
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}


	public List<ItemPedido> getItensPedido() {
		return itens;
	}

	public void setItensPedido(List<ItemPedido> itensPedido) {
		this.itens = itensPedido;
	}
	
	
	
}
