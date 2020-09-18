package com.example.facciaLibro.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.facciaLibro.entity.Utente;

public interface UtentiRepository extends CrudRepository<Utente, Long> {

		public List<Utente> findByNome(String nome);
		
		public List<Utente> findByCognome(String cognome);

	}


