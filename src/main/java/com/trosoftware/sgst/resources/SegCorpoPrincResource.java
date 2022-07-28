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

import com.trosoftware.sgst.domain.SegCorpoPrinc;
import com.trosoftware.sgst.domain.dtos.SegCorpoPrincDTO;
import com.trosoftware.sgst.services.SegCorpoPrincService;


@RestController
@RequestMapping(value = "/segCorpoPrinc")
public class SegCorpoPrincResource {

	@Autowired
	private SegCorpoPrincService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<SegCorpoPrincDTO> findById(@PathVariable Integer id) {
		SegCorpoPrinc obj = service.findById(id);
		return ResponseEntity.ok().body(new SegCorpoPrincDTO(obj));
	}

	@GetMapping
	public ResponseEntity<List<SegCorpoPrincDTO>> findAll() {
		List<SegCorpoPrinc> list = service.findAll();
		List<SegCorpoPrincDTO> listDTO = list.stream().map(obj -> new SegCorpoPrincDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping
	public ResponseEntity<SegCorpoPrincDTO> create(@Valid @RequestBody SegCorpoPrincDTO objDTO) {
		SegCorpoPrinc newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PutMapping(value = "/{id}")
	public ResponseEntity<SegCorpoPrincDTO> update(@PathVariable Integer id, @Valid @RequestBody SegCorpoPrincDTO objDTO) {
		SegCorpoPrinc obj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new SegCorpoPrincDTO(obj));
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<SegCorpoPrincDTO> delete(@PathVariable Integer id) {
		service.delete(id); 
		return ResponseEntity.noContent().build();
	}

}
 

















