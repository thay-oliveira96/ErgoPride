package com.trosoftware.sgst.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trosoftware.sgst.domain.AetPosto;
import com.trosoftware.sgst.domain.Funcoes;
import com.trosoftware.sgst.domain.SegCorpoPrinc;
import com.trosoftware.sgst.domain.dtos.AetPostoDTO;
import com.trosoftware.sgst.repositories.AetPostoRepository;
import com.trosoftware.sgst.services.exeptions.ObjectnotFoundException;

@Service
public class AetPostoService {

	@Autowired
	private AetPostoRepository repository;
	@Autowired
	private FuncoeService funcoeService;
	@Autowired
	private SegCorpoPrincService segCorpoPrincService;

	public AetPosto findById(Integer id) {
		Optional<AetPosto> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! Id: " + id));
	}

	public List<AetPosto> findAll() {
		return repository.findAll();
	}

	public AetPosto create(AetPostoDTO obj) {
		obj.setId(null);
		return repository.save(newAetPosto(obj));
	}
 
	public AetPosto update(Integer id, @Valid AetPostoDTO objDTO) {
		objDTO.setId(id);
		AetPosto oldObj = findById(id);
		oldObj = newAetPosto(objDTO);
		return repository.save(oldObj);
	}
	
	//Classe para salvar o item
	
	private AetPosto newAetPosto(AetPostoDTO obj) {
		
		Funcoes cargos = funcoeService.findById(obj.getCargo());
		SegCorpoPrinc segmCorp = segCorpoPrincService.findById(obj.getSegCorpoPrinc());
		
		AetPosto aetPosto = new AetPosto();
		
		aetPosto.setCargo(cargos);
		aetPosto.setCod(obj.getCod());
		aetPosto.setSegCorpoPrinc(segmCorp);
		aetPosto.setDemSegm(segmCorp);
		aetPosto.setGrauRisco(obj.getGrauRisco());
		aetPosto.setFatoresRisco(obj.getFatoresRisco());
		aetPosto.setDiagnosticoGlobal(obj.getDiagnosticoGlobal());
		aetPosto.setRecomendacoes(obj.getRecomendacoes());
		
		return aetPosto;
		
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	/*private void validaDescricao(AetCargoDTO objDTO) {
		Optional<AetCargo> obj = repository.findByCod(objDTO.getCod());
		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("Há um objeto com esse mesmo nome já cadastrado!");
		}
	}*/

	}
