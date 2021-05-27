package com.meuprojeto.vendas.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meuprojeto.vendas.DTO.VendedorDTO;
import com.meuprojeto.vendas.servico.ServicoVendedor;

@RestController
@RequestMapping(value = "/vendedores")
public class ContoladorVendedor {
	
	@Autowired
	private ServicoVendedor servico;
	
	@GetMapping
	public ResponseEntity<List<VendedorDTO>>findAll(){
		List<VendedorDTO> list = servico.findAll();
		return ResponseEntity.ok(list);
		
	}
	

}
