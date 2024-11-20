package com.jardimdigital.marvel.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jardimdigital.marvel.entities.Personagem;
import com.jardimdigital.marvel.entities.dto.PersonagemDTO;
import com.jardimdigital.marvel.repositories.PersonagemRepository;

@Service
public class PersonagemService {

	private final PersonagemRepository repository;

	public PersonagemService(PersonagemRepository repository) {
		this.repository = repository;
	}

	public PersonagemDTO buscarPersonagem(Long id) {
		Personagem entity = repository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Personagem não encontrado"));
		return new PersonagemDTO(entity);
	}

	public PersonagemDTO buscarPersonagemNome(String nome) {
		Personagem entity = repository.findByNome(nome);
		return new PersonagemDTO(entity);
	}

	public List<PersonagemDTO> listarPersonagens() {
		List<Personagem> objs = repository.findAll();
		List<PersonagemDTO> entites = objs.stream().map(personagem -> new PersonagemDTO(personagem))
				.collect(Collectors.toList());
		return entites;
	}

	public PersonagemDTO salvarPersonagem(PersonagemDTO personagem) {
		Personagem entity = new Personagem();
		copyDtoToEntity(entity, personagem);
		repository.save(entity);
		return new PersonagemDTO(entity);
	}

	public PersonagemDTO atualizarPersonagem(Long id, PersonagemDTO entity) {
		Optional<Personagem> obj = repository.findById(id);
		if (!obj.isPresent()) {
			throw new IllegalArgumentException("Personagem não encontrado");
		}
		Personagem personagem = obj.get();
		updateData(personagem, entity);
		repository.save(personagem);
		return new PersonagemDTO(personagem);
	}

	public void deletarPersonagem(Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
		} else {
			throw new IllegalArgumentException("Personagem não encontrado");
		}
	}

	private void copyDtoToEntity(Personagem entity, PersonagemDTO dto) {
		entity.setNome(dto.getNome());
		entity.setPopularidade(dto.getPopularidade());
		entity.setAparicoes(dto.getAparicoes());
		entity.setUrl_foto(dto.getUrl_foto());
	}

	private void updateData(Personagem entity, PersonagemDTO dto) {
		entity.setPopularidade(dto.getPopularidade());
		entity.setAparicoes(dto.getAparicoes());
		entity.setUrl_foto(dto.getUrl_foto());
	}

}