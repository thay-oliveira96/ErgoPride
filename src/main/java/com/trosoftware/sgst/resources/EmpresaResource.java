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

import com.trosoftware.sgst.domain.Empresas;
import com.trosoftware.sgst.domain.dtos.EmpresasDTO;
import com.trosoftware.sgst.services.EmpresaService;


@RestController
@RequestMapping(value = "/empresas")
public class EmpresaResource {

	@Autowired
	private EmpresaService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<EmpresasDTO> findById(@PathVariable Integer id) {
		Empresas obj = service.findById(id);
		return ResponseEntity.ok().body(new EmpresasDTO(obj));
	}

	@GetMapping
	public ResponseEntity<List<EmpresasDTO>> findAll() {
		List<Empresas> list = service.findAll();
		List<EmpresasDTO> listDTO = list.stream().map(obj -> new EmpresasDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping
	public ResponseEntity<EmpresasDTO> create(@Valid @RequestBody EmpresasDTO objDTO) {
		Empresas newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PutMapping(value = "/{id}")
	public ResponseEntity<EmpresasDTO> update(@PathVariable Integer id, @Valid @RequestBody EmpresasDTO objDTO) {
		Empresas obj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new EmpresasDTO(obj));
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<EmpresasDTO> delete(@PathVariable Integer id) {
		service.delete(id); 
		return ResponseEntity.noContent().build();
	}

}
 

















