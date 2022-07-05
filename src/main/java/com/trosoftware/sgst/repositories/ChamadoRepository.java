package com.trosoftware.sgst.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trosoftware.sgst.domain.Chamado;

//Pesistencia de dados

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

}