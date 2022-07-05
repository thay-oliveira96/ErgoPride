package com.trosoftware.sgst.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trosoftware.sgst.domain.Empresas;

//Pesistencia de dados

public interface EmpresaRepository extends JpaRepository<Empresas, Integer> {

}
