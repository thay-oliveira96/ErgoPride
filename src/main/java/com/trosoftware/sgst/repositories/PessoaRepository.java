package com.trosoftware.sgst.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trosoftware.sgst.domain.Pessoa;

//Pesistencia de dados

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

	Optional<Pessoa> findByCpf(String cpf);
	Optional<Pessoa> findByEmail(String email);

}
