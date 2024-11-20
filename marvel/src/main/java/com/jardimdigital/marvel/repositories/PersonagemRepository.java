package com.jardimdigital.marvel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jardimdigital.marvel.entities.Personagem;

@Repository
public interface PersonagemRepository extends JpaRepository<Personagem, Long> {

	Personagem findByNome(String nome);
}