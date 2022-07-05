package com.trosoftware.sgst.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trosoftware.sgst.domain.Cliente;

//Pesistencia de dados

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
