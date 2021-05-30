package com.meuprojeto.vendas.dto;

import java.io.Serializable;

import com.meuprojeto.vendas.entidades.Vendedor;

public class VendaSumDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String vendedorName;
	private Double sum;
	
	public VendaSumDTO() {
		
	}

	public VendaSumDTO(Vendedor vendedor, Double sum) {
		super();
		this.vendedorName = vendedor.getName();
		this.sum = sum;
	}

	public String getVendedorName() {
		return vendedorName;
	}

	public void setVendedorName(String vendedorName) {
		this.vendedorName = vendedorName;
	}

	public Double getSum() {
		return sum;
	}

	public void setSum(Double sum) {
		this.sum = sum;
	}

	

}
