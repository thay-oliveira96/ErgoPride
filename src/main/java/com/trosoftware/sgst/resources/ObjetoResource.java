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

import com.trosoftware.sgst.domain.Objeto;
import com.trosoftware.sgst.domain.dtos.ObjetoDTO;
import com.trosoftware.sgst.services.ObjetoService;


@RestController
@RequestMapping(value = "/objetos")
public class ObjetoResource {

	@Autowired
	private ObjetoService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<ObjetoDTO> findById(@PathVariable Integer id) {
		Objeto obj = service.findById(id);
		return ResponseEntity.ok().body(new ObjetoDTO(obj));
	}

	@GetMapping
	public ResponseEntity<List<ObjetoDTO>> findAll() {
		List<Objeto> list = service.findAll();
		List<ObjetoDTO> listDTO = list.stream().map(obj -> new ObjetoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping
	public ResponseEntity<ObjetoDTO> create(@Valid @RequestBody ObjetoDTO objDTO) {
		Objeto newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PutMapping(value = "/{id}")
	public ResponseEntity<ObjetoDTO> update(@PathVariable Integer id, @Valid @RequestBody ObjetoDTO objDTO) {
		Objeto obj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new ObjetoDTO(obj));
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ObjetoDTO> delete(@PathVariable Integer id) {
		service.delete(id); 
		return ResponseEntity.noContent().build();
	}

}
 

















