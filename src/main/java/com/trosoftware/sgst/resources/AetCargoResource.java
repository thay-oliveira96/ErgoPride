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

import com.trosoftware.sgst.domain.AetCargo;
import com.trosoftware.sgst.domain.dtos.AetCargoDTO;
import com.trosoftware.sgst.services.AetCargoService;


@RestController
@RequestMapping(value = "/aetCargos")
public class AetCargoResource {

	@Autowired
	private AetCargoService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<AetCargoDTO> findById(@PathVariable Integer id) {
		AetCargo obj = service.findById(id);
		return ResponseEntity.ok().body(new AetCargoDTO(obj));
	}

	@GetMapping
	public ResponseEntity<List<AetCargoDTO>> findAll() {
		List<AetCargo> list = service.findAll();
		List<AetCargoDTO> listDTO = list.stream().map(obj -> new AetCargoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping
	public ResponseEntity<AetCargoDTO> create(@Valid @RequestBody AetCargoDTO objDTO) {
		AetCargo newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PutMapping(value = "/{id}")
	public ResponseEntity<AetCargoDTO> update(@PathVariable Integer id, @Valid @RequestBody AetCargoDTO objDTO) {
		AetCargo obj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new AetCargoDTO(obj));
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<AetCargoDTO> delete(@PathVariable Integer id) {
		service.delete(id); 
		return ResponseEntity.noContent().build();
	}

}
 

















