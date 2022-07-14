package com.trosoftware.sgst.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trosoftware.sgst.domain.Funcoes;
import com.trosoftware.sgst.domain.dtos.FuncoesDTO;
import com.trosoftware.sgst.repositories.FuncoesRepository;
import com.trosoftware.sgst.services.exeptions.DataIntegrityViolationException;
import com.trosoftware.sgst.services.exeptions.ObjectnotFoundException;

@Service
public class FuncoeService {

	@Autowired
	private FuncoesRepository repository;

	public Funcoes findById(Integer id) {
		Optional<Funcoes> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! Id: " + id));
	}

	public List<Funcoes> findAll() {
		return repository.findAll();
	}

	public Funcoes create(FuncoesDTO objDTO) {
		objDTO.setId(null);
		validaNome(objDTO);
		Funcoes newObj = new Funcoes(objDTO);
		return repository.save(newObj);
	}
 
	public Funcoes update(Integer id, @Valid FuncoesDTO objDTO) {
		objDTO.setId(id);
		Funcoes oldObj = findById(id);
		
		oldObj = new Funcoes(objDTO);
		return repository.save(oldObj);
	}

	public void delete(Integer id) {
		Funcoes obj = findById(id);

		repository.deleteById(id);
	}

	private void validaNome(FuncoesDTO objDTO) {
		Optional<Funcoes> obj = repository.findByNome(objDTO.getNome());
		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("Há um departamento com esse mesmo nome já cadastrado!");
		}

	}

}
