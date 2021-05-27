package com.meuprojeto.vendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meuprojeto.vendas.entidades.Venda;

public interface RepositorioVenda extends JpaRepository<Venda, Long>{

}
