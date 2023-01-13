package com.trosoftware.sgst.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trosoftware.sgst.domain.AetCargo;

//Pesistencia de dados

public interface AetCargoRepository extends JpaRepository<AetCargo, Integer> {
	Optional<AetCargo> findByCod(String aetCargo);
}
