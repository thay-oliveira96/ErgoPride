package com.trosoftware.sgst.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trosoftware.sgst.domain.AetEmpresa;
import com.trosoftware.sgst.domain.dtos.AetEmpresaDTO;
import com.trosoftware.sgst.repositories.AetEmpresaRepository;
import com.trosoftware.sgst.services.exeptions.ObjectnotFoundException;

@Service
public class AetEmpresaService {

	@Autowired
	private AetEmpresaRepository repository;
	@Autowired
	private EmpresaService empresaService;

	public AetEmpresa findById(Integer id) {
		Optional<AetEmpresa> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! Id: " + id));
	}

	public List<AetEmpresa> findAll() {
		return repository.findAll();
	}

	public AetEmpresa create(AetEmpresaDTO objDTO) {
		objDTO.setId(null);
		//validaCod(objDTO);
		AetEmpresa newObj = new AetEmpresa(objDTO);
		return repository.save(newObj);
	}
 
	public AetEmpresa update(Integer id, @Valid AetEmpresaDTO objDTO) {
		objDTO.setId(id);
		AetEmpresa oldObj = findById(id);
		
		oldObj = new AetEmpresa(objDTO);
		return repository.save(oldObj);
	}

	public void delete(Integer id) {
		AetEmpresa obj = findById(id);

		repository.deleteById(id);
	}
	/*private AetEmpresa newAetEmpresa(AetEmpresaDTO obj) {
		AetEmpresa aetEmpresas = empresaService.findById(obj.getEmpresa());
	}*/

	}
