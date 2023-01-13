package com.trosoftware.sgst.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trosoftware.sgst.domain.SegCorpoPrinc;

//Pesistencia de dados

public interface SegCorpoPrincRepository extends JpaRepository<SegCorpoPrinc, Integer> {
	Optional<SegCorpoPrinc> findByDescricao(String segCorpoPrinc);
}
