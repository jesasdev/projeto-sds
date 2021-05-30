package com.meuprojeto.vendas.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meuprojeto.vendas.dto.VendaDTO;
import com.meuprojeto.vendas.dto.VendaSuccessDTO;
import com.meuprojeto.vendas.dto.VendaSumDTO;
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
	@GetMapping(value = "/montante-by-vendedor")
	public ResponseEntity<List<VendaSumDTO>> montanteGroupdBayVendedor(){
		List<VendaSumDTO> list = servico.montanteGroupdByVendedor();
		return ResponseEntity.ok(list);
		
	}
	
	@GetMapping(value = "/success-by-vendedor")
	public ResponseEntity<List<VendaSuccessDTO>> successGroupdBayVendedor(){
		List<VendaSuccessDTO> list = servico.successGroupdByVendedor();
		return ResponseEntity.ok(list);
		
	}

}
