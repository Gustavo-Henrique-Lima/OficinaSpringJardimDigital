package com.jardimdigital.marvel.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jardimdigital.marvel.entities.dto.PersonagemDTO;
import com.jardimdigital.marvel.services.PersonagemService;

@RestController
@RequestMapping(value = "/personagens")
public class PersonagemController {

	private final PersonagemService service;

	public PersonagemController(PersonagemService service) {
		this.service = service;
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<PersonagemDTO> buscarPersonagem(@PathVariable Long id) {
		PersonagemDTO Personagem = service.buscarPersonagem(id);
		return ResponseEntity.ok(Personagem);
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<PersonagemDTO> buscarPersonagemPorNome(@PathVariable String nome) {
		PersonagemDTO Personagem = service.buscarPersonagemNome(nome);
		return ResponseEntity.ok(Personagem);
	}

	@GetMapping("/listar")
	public ResponseEntity<List<PersonagemDTO>> listarPersonagems() {
		List<PersonagemDTO> Personagens = service.listarPersonagens();
		return ResponseEntity.ok(Personagens);
	}

	@PostMapping("/salvar")
	public PersonagemDTO salvarPersonagem(@RequestBody PersonagemDTO Personagem) {
		return service.salvarPersonagem(Personagem);
	}

	@PutMapping("/atualizar/{id}")
	public ResponseEntity<PersonagemDTO> atualizarPersonagem(@PathVariable Long id,
			@RequestBody PersonagemDTO Personagem) {
		PersonagemDTO PersonagemAtualizado = service.atualizarPersonagem(id, Personagem);
		return ResponseEntity.ok(PersonagemAtualizado);
	}

	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Void> deletarPersonagem(@PathVariable Long id) {
		service.deletarPersonagem(id);
		return ResponseEntity.noContent().build();
	}
}