package com.meuprojeto.vendas.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meuprojeto.vendas.DTO.VendaDTO;
import com.meuprojeto.vendas.servico.ServicoVenda;

@RestController
@RequestMapping(value = "/vendas")
public class ContoladorVenda {
	
	@Autowired
	private ServicoVenda servico;
	
	@GetMapping
	public ResponseEntity<Page<VendaDTO>>findAll(Pageable pageable){
		Page<VendaDTO> list = servico.findAll(pageable);
		return ResponseEntity.ok(list);
		
	}
	

}
