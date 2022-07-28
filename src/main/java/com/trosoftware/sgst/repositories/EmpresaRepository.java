package com.trosoftware.sgst.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trosoftware.sgst.domain.Empresas;

//Pesistencia de dados

public interface EmpresaRepository extends JpaRepository<Empresas, Integer> {
	Optional<Empresas> findByCnpj(String cnpj);
}
