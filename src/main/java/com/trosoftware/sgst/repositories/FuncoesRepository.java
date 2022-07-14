package com.trosoftware.sgst.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trosoftware.sgst.domain.Funcoes;

//Pesistencia de dados

public interface FuncoesRepository extends JpaRepository<Funcoes, Integer> {
	Optional<Funcoes> findByNome(String nome);
}
