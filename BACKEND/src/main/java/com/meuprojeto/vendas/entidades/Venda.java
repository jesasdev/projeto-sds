package com.meuprojeto.vendas.entidades;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_vendas")
public class Venda {
	
	//informar ao banco que o Id é auto-increment
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	private Integer visitado;
	private Integer fechamento;
	private Double montante;
	private LocalDate date;
	
	
	//Mapeando a chave estrangeira
	@ManyToOne
	@JoinColumn(name = "vendedor_id")
	private Vendedor vendedor;
	
	public Venda() {
		
	}

	public Venda(Long id, Integer visitado, Integer fechamento, Double montante, LocalDate date, Vendedor vendedor) {
		this.id = id;
		this.visitado = visitado;
		this.fechamento = fechamento;
		this.montante = montante;
		this.date = date;
		this.vendedor = vendedor;
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

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

}
