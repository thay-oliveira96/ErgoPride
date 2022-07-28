package com.trosoftware.sgst.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trosoftware.sgst.domain.Objeto;
import com.trosoftware.sgst.domain.dtos.ObjetoDTO;
import com.trosoftware.sgst.repositories.ObjetoRepository;
import com.trosoftware.sgst.services.exeptions.DataIntegrityViolationException;
import com.trosoftware.sgst.services.exeptions.ObjectnotFoundException;

@Service
public class ObjetoService {

	@Autowired
	private ObjetoRepository repository;

	public Objeto findById(Integer id) {
		Optional<Objeto> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! Id: " + id));
	}

	public List<Objeto> findAll() {
		return repository.findAll();
	}

	public Objeto create(ObjetoDTO objDTO) {
		objDTO.setId(null);
		validaDescricao(objDTO);
		Objeto newObj = new Objeto(objDTO);
		return repository.save(newObj);
	}
 
	public Objeto update(Integer id, @Valid ObjetoDTO objDTO) {
		objDTO.setId(id);
		Objeto oldObj = findById(id);
		
		oldObj = new Objeto(objDTO);
		return repository.save(oldObj);
	}

	public void delete(Integer id) {
		Objeto obj = findById(id);

		repository.deleteById(id);
	}

	private void validaDescricao(ObjetoDTO objDTO) {
		Optional<Objeto> obj = repository.findByDescricao(objDTO.getDescricao());
		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("Há um objeto com esse mesmo nome já cadastrado!");
		}

	}

}
