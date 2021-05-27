package com.meuprojeto.vendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meuprojeto.vendas.entidades.Vendedor;

public interface RepositorioVendedor extends JpaRepository<Vendedor, Long>{

}
