package com.example.facciaLibro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.facciaLibro.entity.Indirizzo;
import com.example.facciaLibro.entity.Telefono;
import com.example.facciaLibro.entity.Utente;
import com.example.facciaLibro.repository.TelefonoRepository;

@Service
public class TelefonoService {

	@Autowired
	TelefonoRepository telefonoRepository;

	public List<Telefono> creaTelefono(List<Telefono> listaTelefono) {

		List<Telefono> telefoniSalvati = new ArrayList<>();
		Utente utenteAggiornare = new Utente();
		
		for (Telefono numeroSalvare : listaTelefono) {

			
			telefonoRepository.save(numeroSalvare);
			
			
		//Telefono telefonoSalvato = telefonoRepository.save(numeroSalvare);
		telefoniSalvati.add(numeroSalvare);
		utenteAggiornare.setTelefono(telefoniSalvati);

		}
		return telefoniSalvati;

	}

}
