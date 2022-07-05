package com.trosoftware.sgst.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trosoftware.sgst.domain.Tecnico;

//Pesistencia de dados

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {

}
