package com.example.facciaLibro.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.facciaLibro.entity.Indirizzo;
import com.example.facciaLibro.entity.Utente;

@Repository
public interface IndirizzoRepository  extends CrudRepository<Indirizzo, Long> {

}
