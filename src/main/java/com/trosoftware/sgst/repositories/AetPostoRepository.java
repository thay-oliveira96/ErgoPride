package com.trosoftware.sgst.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trosoftware.sgst.domain.AetPosto;

//Pesistencia de dados

public interface AetPostoRepository extends JpaRepository<AetPosto, Integer> {
	Optional<AetPosto> findByCod(String aetPosto);
}