package com.trosoftware.sgst.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.trosoftware.sgst.domain.Empresas;
import com.trosoftware.sgst.domain.Tecnico;
import com.trosoftware.sgst.domain.dtos.EmpresasDTO;
import com.trosoftware.sgst.repositories.EmpresaRepository;
import com.trosoftware.sgst.services.exeptions.DataIntegrityViolationException;
import com.trosoftware.sgst.services.exeptions.ObjectnotFoundException;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository repository;

	public Empresas findById(Integer id) {
		Optional<Empresas> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! Id: " + id));
	}

	public List<Empresas> findAll() {
		return repository.findAll();
	}

	public Empresas create(EmpresasDTO objDTO) {
		objDTO.setId(null);
		validaCnpj(objDTO);
		Empresas newObj = new Empresas(objDTO);
		return repository.save(newObj);
	}
 
	public Empresas update(Integer id, @Valid EmpresasDTO objDTO) {
		objDTO.setId(id);
		Empresas oldObj = findById(id);
		
		validaCnpj(objDTO);
		oldObj = new Empresas(objDTO);
		return repository.save(oldObj);
	}

	public void delete(Integer id) {
		Empresas obj = findById(id);

		repository.deleteById(id);
	}

	private void validaCnpj(EmpresasDTO objDTO) {
		Optional<Empresas> obj = repository.findByCnpj(objDTO.getCnpj());
		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("CNPJ já cadastrado no sistema!");
		}

	}

}
