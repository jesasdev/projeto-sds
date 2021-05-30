package com.meuprojeto.vendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.meuprojeto.vendas.dto.VendaSuccessDTO;
import com.meuprojeto.vendas.dto.VendaSumDTO;
import com.meuprojeto.vendas.entidades.Venda;

public interface RepositorioVenda extends JpaRepository<Venda, Long>{
	
	@Query("SELECT new com.meuprojeto.vendas.dto.VendaSumDTO(obj.vendedor,SUM(obj.montante)) "
			+" FROM Venda AS obj GROUP BY obj.vendedor")
	List<VendaSumDTO>montanteGroupdByVendedor();

	@Query("SELECT new com.meuprojeto.vendas.dto.VendaSuccessDTO(obj.vendedor,SUM(obj.visitado),SUM(obj.fechamento)) "
			+" FROM Venda AS obj GROUP BY obj.vendedor")
	List<VendaSuccessDTO>successGroupdByVendedor();

	
	
}
