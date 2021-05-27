package com.meuprojeto.vendas.servico;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meuprojeto.vendas.DTO.VendedorDTO;
import com.meuprojeto.vendas.entidades.Vendedor;
import com.meuprojeto.vendas.repositories.RepositorioVendedor;

@Service
public class ServicoVendedor {
	
	@Autowired
	private RepositorioVendedor repositorio;
	
	public List<VendedorDTO> findAll(){
		List<Vendedor> result = repositorio.findAll();
		return result.stream().map(x -> new VendedorDTO(x)).collect(Collectors.toList());
	}

}
