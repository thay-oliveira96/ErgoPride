package com.trosoftware.sgst.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trosoftware.sgst.domain.SegCorpoPrinc;
import com.trosoftware.sgst.domain.dtos.SegCorpoPrincDTO;
import com.trosoftware.sgst.repositories.SegCorpoPrincRepository;
import com.trosoftware.sgst.services.exeptions.DataIntegrityViolationException;
import com.trosoftware.sgst.services.exeptions.ObjectnotFoundException;

@Service
public class SegCorpoPrincService {

	@Autowired
	private SegCorpoPrincRepository repository;

	public SegCorpoPrinc findById(Integer id) {
		Optional<SegCorpoPrinc> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Segmento não encontrado! Id: " + id));
	}

	public List<SegCorpoPrinc> findAll() {
		return repository.findAll();
	}

	public SegCorpoPrinc create(SegCorpoPrincDTO objDTO) {
		objDTO.setId(null);
		validaDescricao(objDTO);
		SegCorpoPrinc newObj = new SegCorpoPrinc(objDTO);
		return repository.save(newObj);
	}
 
	public SegCorpoPrinc update(Integer id, @Valid SegCorpoPrincDTO objDTO) {
		objDTO.setId(id);
		SegCorpoPrinc oldObj = findById(id);
		
		oldObj = new SegCorpoPrinc(objDTO);
		return repository.save(oldObj);
	}

	public void delete(Integer id) {
		SegCorpoPrinc obj = findById(id);

		repository.deleteById(id);
	}

	private void validaDescricao(SegCorpoPrincDTO objDTO) {
		Optional<SegCorpoPrinc> obj = repository.findByDescricao(objDTO.getDescricao());
		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("Há um Segmento com esse mesmo nome já cadastrado!");
		}

	}

}
