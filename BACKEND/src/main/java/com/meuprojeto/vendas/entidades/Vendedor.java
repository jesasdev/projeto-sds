package com.meuprojeto.vendas.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "tb_vendedores")
public class Vendedor {
	
	//informar ao banco que o Id é auto-increment
		@Id
		@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@OneToMany(mappedBy = "vendedor")
	private List<Venda>vendas = new ArrayList<>();
	
	public Vendedor() {
		
	}

	public Vendedor(Long id, String name) {
		this.id = id;
		this.name = name;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Venda> getVendas() {
		return vendas;
	}
	
	
}
