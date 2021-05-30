package com.meuprojeto.vendas.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.meuprojeto.vendas.dto.VendaDTO;
import com.meuprojeto.vendas.dto.VendaSuccessDTO;
import com.meuprojeto.vendas.dto.VendaSumDTO;
import com.meuprojeto.vendas.entidades.Venda;
import com.meuprojeto.vendas.repositories.RepositorioVenda;
import com.meuprojeto.vendas.repositories.RepositorioVendedor;

@Service
public class ServicoVenda {
	
	@Autowired
	private RepositorioVenda repositorio;
	
	
	@Autowired
	private RepositorioVendedor repositorioVendedor;
	//busca paginada
	@Transactional(readOnly = true)
	public Page<VendaDTO> findAll(Pageable pageable){
		//armazena em memoria evitando que faça várias buscas
		repositorioVendedor.findAll();
		Page<Venda> result = repositorio.findAll(pageable);
		return result.map(x -> new VendaDTO(x));
	}

	@Transactional(readOnly = true)
	public List<VendaSumDTO>montanteGroupdByVendedor(){
		return repositorio.montanteGroupdByVendedor();
	}
	
	@Transactional(readOnly = true)
	public List<VendaSuccessDTO>successGroupdByVendedor(){
		return repositorio.successGroupdByVendedor();
	}
	
	
}
