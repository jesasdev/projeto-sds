package com.meuprojeto.vendas.dto;

import java.io.Serializable;

import com.meuprojeto.vendas.entidades.Vendedor;

public class VendaSuccessDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String vendedorName;
	private Long visitado;
	private Long fechamento;
	
	public VendaSuccessDTO() {
		
	}

	

	public VendaSuccessDTO(Vendedor vendedor, Long visitado, Long fechamento) {
	    vendedorName = vendedor.getName();
		this.visitado = visitado;
		this.fechamento = fechamento;
	}



	public String getVendedorName() {
		return vendedorName;
	}

	public void setVendedorName(String vendedorName) {
		this.vendedorName = vendedorName;
	}



	public Long getVisitado() {
		return visitado;
	}



	public void setVisitado(Long visitado) {
		this.visitado = visitado;
	}



	public Long getFechamento() {
		return fechamento;
	}



	public void setFechamento(Long fechamento) {
		this.fechamento = fechamento;
	}

	

	

}
