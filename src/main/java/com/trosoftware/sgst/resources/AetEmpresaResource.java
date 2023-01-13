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

import com.trosoftware.sgst.domain.AetEmpresa;
import com.trosoftware.sgst.domain.dtos.AetEmpresaDTO;
import com.trosoftware.sgst.services.AetEmpresaService;


@RestController
@RequestMapping(value = "/aetEmpresas")
public class AetEmpresaResource {

	@Autowired
	private AetEmpresaService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<AetEmpresaDTO> findById(@PathVariable Integer id) {
		AetEmpresa obj = service.findById(id);
		return ResponseEntity.ok().body(new AetEmpresaDTO(obj));
	}

	@GetMapping
	public ResponseEntity<List<AetEmpresaDTO>> findAll() {
		List<AetEmpresa> list = service.findAll();
		List<AetEmpresaDTO> listDTO = list.stream().map(obj -> new AetEmpresaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping
	public ResponseEntity<AetEmpresaDTO> create(@Valid @RequestBody AetEmpresaDTO objDTO) {
		AetEmpresa newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PutMapping(value = "/{id}")
	public ResponseEntity<AetEmpresaDTO> update(@PathVariable Integer id, @Valid @RequestBody AetEmpresaDTO objDTO) {
		AetEmpresa obj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new AetEmpresaDTO(obj));
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<AetEmpresaDTO> delete(@PathVariable Integer id) {
		service.delete(id); 
		return ResponseEntity.noContent().build();
	}

}
 

















