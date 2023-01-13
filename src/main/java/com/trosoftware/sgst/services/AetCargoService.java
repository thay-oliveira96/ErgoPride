package com.trosoftware.sgst.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trosoftware.sgst.domain.AetCargo;
import com.trosoftware.sgst.domain.dtos.AetCargoDTO;
import com.trosoftware.sgst.repositories.AetCargoRepository;
import com.trosoftware.sgst.services.exeptions.ObjectnotFoundException;

@Service
public class AetCargoService {

	@Autowired
	private AetCargoRepository repository;

	public AetCargo findById(Integer id) {
		Optional<AetCargo> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! Id: " + id));
	}

	public List<AetCargo> findAll() {
		return repository.findAll();
	}

	public AetCargo create(AetCargoDTO objDTO) {
		objDTO.setId(null);
		//validaDescricao(objDTO);
		AetCargo newObj = new AetCargo(objDTO);
		return repository.save(newObj);
	}
 
	public AetCargo update(Integer id, @Valid AetCargoDTO objDTO) {
		objDTO.setId(id);
		AetCargo oldObj = findById(id);
		
		oldObj = new AetCargo(objDTO);
		return repository.save(oldObj);
	}

	public void delete(Integer id) {
		AetCargo obj = findById(id);

		repository.deleteById(id);
	}

	/*private void validaDescricao(AetCargoDTO objDTO) {
		Optional<AetCargo> obj = repository.findByCod(objDTO.getCod());
		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("Há um objeto com esse mesmo nome já cadastrado!");
		}
	}*/

	}
