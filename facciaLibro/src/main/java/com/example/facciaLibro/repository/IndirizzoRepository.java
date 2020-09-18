package com.example.facciaLibro.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.facciaLibro.entity.Indirizzo;
import com.example.facciaLibro.entity.Utente;

public interface IndirizzoRepository  extends CrudRepository<Indirizzo, Long> {

}
