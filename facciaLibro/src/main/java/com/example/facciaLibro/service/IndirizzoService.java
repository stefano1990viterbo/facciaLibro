package com.example.facciaLibro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.facciaLibro.entity.Indirizzo;
import com.example.facciaLibro.entity.Utente;
import com.example.facciaLibro.repository.IndirizzoRepository;

@Service
public class IndirizzoService {

	@Autowired
	IndirizzoRepository indirizzoRepository;

	// private String indirizzoCompleto;

//	public String getIndirizzoCompleto() {
//		return indirizzoCompleto;
//	}
//
//	public void setIndirizzoCompleto(String indirizzoCompleto) {
//		this.indirizzoCompleto = indirizzoCompleto;
//	}

	public Indirizzo associaIndirizzo(Indirizzo indirizzo) {
		Indirizzo indirizzoSalvato = indirizzoRepository.save(indirizzo);

		indirizzoSalvato.setIndirizzoCompleto(indirizzoSalvato.getVia() +" "+indirizzoSalvato.getCivico()
				+" "+ indirizzoSalvato.getComune() + " "+indirizzoSalvato.getProvincia());

		return indirizzoSalvato;

	}

}
