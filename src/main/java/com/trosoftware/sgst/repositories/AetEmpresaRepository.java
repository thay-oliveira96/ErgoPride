package com.trosoftware.sgst.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trosoftware.sgst.domain.AetEmpresa;

//Pesistencia de dados

public interface AetEmpresaRepository extends JpaRepository<AetEmpresa, Integer> {
	
}
