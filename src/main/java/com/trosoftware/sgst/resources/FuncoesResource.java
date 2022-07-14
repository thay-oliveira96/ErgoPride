package com.trosoftware.sgst.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.trosoftware.sgst.domain.Funcoes;
import com.trosoftware.sgst.domain.dtos.FuncoesDTO;
import com.trosoftware.sgst.services.FuncoeService;


@RestController
@RequestMapping(value = "/funcoes")
public class FuncoesResource {

	@Autowired
	private FuncoeService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<FuncoesDTO> findById(@PathVariable Integer id) {
		Funcoes obj = service.findById(id);
		return ResponseEntity.ok().body(new FuncoesDTO(obj));
	}

	@GetMapping
	public ResponseEntity<List<FuncoesDTO>> findAll() {
		List<Funcoes> list = service.findAll();
		List<FuncoesDTO> listDTO = list.stream().map(obj -> new FuncoesDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping
	public ResponseEntity<FuncoesDTO> create(@Valid @RequestBody FuncoesDTO objDTO) {
		Funcoes newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PutMapping(value = "/{id}")
	public ResponseEntity<FuncoesDTO> update(@PathVariable Integer id, @Valid @RequestBody FuncoesDTO objDTO) {
		Funcoes obj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new FuncoesDTO(obj));
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<FuncoesDTO> delete(@PathVariable Integer id) {
		service.delete(id); 
		return ResponseEntity.noContent().build();
	}

}
 

















