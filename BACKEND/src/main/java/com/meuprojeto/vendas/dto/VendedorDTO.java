package com.meuprojeto.vendas.dto;

import java.io.Serializable;

import com.meuprojeto.vendas.entidades.Vendedor;

public class VendedorDTO  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	
	public VendedorDTO() {
		
	}

	public VendedorDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	public VendedorDTO(Vendedor entidade) {
		id = entidade.getId();
		name = entidade.getName();
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

}
