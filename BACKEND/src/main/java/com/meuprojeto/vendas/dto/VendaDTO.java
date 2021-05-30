package com.meuprojeto.vendas.dto;

import java.time.LocalDate;

import com.meuprojeto.vendas.entidades.Venda;

public class VendaDTO  {
	
	
	private Long id;
	private Integer visitado;
	private Integer fechamento;
	private Double montante;
	private LocalDate date;
	
	private VendedorDTO vendedor;
	
	public VendaDTO() {
		
	}

	public VendaDTO(Long id, Integer visitado, Integer fechamento, Double montante, LocalDate date,
		VendedorDTO vendedor) {
		this.id = id;
		this.visitado = visitado;
		this.fechamento = fechamento;
		this.montante = montante;
		this.date = date;
		this.vendedor = vendedor;
	}
	public VendaDTO(Venda entity) {
			id = entity.getId();
			visitado = entity.getVisitado();
			fechamento = entity.getFechamento();
			montante = entity.getMontante();
			date = entity.getDate();
			vendedor = new VendedorDTO(entity.getVendedor());
		}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVisitado() {
		return visitado;
	}

	public void setVisitado(Integer visitado) {
		this.visitado = visitado;
	}

	public Integer getFechamento() {
		return fechamento;
	}

	public void setFechamento(Integer fechamento) {
		this.fechamento = fechamento;
	}

	public Double getMontante() {
		return montante;
	}

	public void setMontante(Double montante) {
		this.montante = montante;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public VendedorDTO getVendedor() {
		return vendedor;
	}

	public void setVendedor(VendedorDTO vendedor) {
		this.vendedor = vendedor;
	}
	
	}


