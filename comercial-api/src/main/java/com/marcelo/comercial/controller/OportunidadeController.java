package com.marcelo.comercial.controller;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.marcelo.comercial.model.Oportunidade;
import com.marcelo.comercial.repository.OportunidadeRepository;

@RestController
@RequestMapping("/oportunidades")
@CrossOrigin("*")
public class OportunidadeController {
	
	@Autowired
	private OportunidadeRepository oportunidadeRepository;
	
	@GetMapping
	@PreAuthorize("hasAnyRole('ADMIN', 'CUSTOMER')")
	public List<Oportunidade> listar() {
		return oportunidadeRepository.findAll();
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAnyRole('ADMIN', 'CUSTOMER')")
	public ResponseEntity<Oportunidade> buscar(@PathVariable Long id) {
		Optional<Oportunidade> oportunidade = oportunidadeRepository.findById(id);
		
		if(!oportunidade.isPresent())
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(oportunidade.get());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasAnyRole('ADMIN', 'CUSTOMER')")
	public Oportunidade adicionar(@Valid @RequestBody Oportunidade oportunidade) {
		Optional<Oportunidade> oportunidadeExist = oportunidadeRepository
				.findByDescricaoAndNomeProspecto(oportunidade.getDescricao(), oportunidade.getNomeProspecto());
		
		if(oportunidadeExist.isPresent())
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
					"Ja existe uma oportunidade para este mesmo prospecto com a mesma descrição.");
		
		return oportunidadeRepository.save(oportunidade);
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasAnyRole('ADMIN')")
	public Oportunidade atualizar (@Valid @RequestBody Oportunidade oportunidade) {	
		return oportunidadeRepository.save(oportunidade);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	@PreAuthorize("hasAnyRole('ADMIN')")
	public void deletar(@PathVariable Long id) {
		oportunidadeRepository.deleteById(id);
	}
}
