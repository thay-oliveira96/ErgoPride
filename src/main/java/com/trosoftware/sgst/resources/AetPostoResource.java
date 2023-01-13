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

import com.trosoftware.sgst.domain.AetPosto;
import com.trosoftware.sgst.domain.dtos.AetPostoDTO;
import com.trosoftware.sgst.services.AetPostoService;


@RestController
@RequestMapping(value = "/aetPostos")
public class AetPostoResource {

	@Autowired
	private AetPostoService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<AetPostoDTO> findById(@PathVariable Integer id) {
		AetPosto obj = service.findById(id);
		return ResponseEntity.ok().body(new AetPostoDTO(obj));
	}

	@GetMapping
	public ResponseEntity<List<AetPostoDTO>> findAll() {
		List<AetPosto> list = service.findAll();
		List<AetPostoDTO> listDTO = list.stream().map(obj -> new AetPostoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping
	public ResponseEntity<AetPostoDTO> create(@Valid @RequestBody AetPostoDTO objDTO) {
		AetPosto newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PutMapping(value = "/{id}")
	public ResponseEntity<AetPostoDTO> update(@PathVariable Integer id, @Valid @RequestBody AetPostoDTO objDTO) {
		AetPosto obj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new AetPostoDTO(obj));
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<AetPostoDTO> delete(@PathVariable Integer id) {
		service.delete(id); 
		return ResponseEntity.noContent().build();
	}

}
 

















