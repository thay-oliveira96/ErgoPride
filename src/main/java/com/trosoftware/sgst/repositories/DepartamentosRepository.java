package com.trosoftware.sgst.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trosoftware.sgst.domain.Departamentos;
import com.trosoftware.sgst.domain.Empresas;

//Pesistencia de dados

public interface DepartamentosRepository extends JpaRepository<Departamentos, Integer> {
	Optional<Departamentos> findByNome(String nome);
}
