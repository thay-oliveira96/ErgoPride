package com.trosoftware.sgst.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trosoftware.sgst.domain.Objeto;

//Pesistencia de dados

public interface ObjetoRepository extends JpaRepository<Objeto, Integer> {
	Optional<Objeto> findByDescricao(String objeto);
}
