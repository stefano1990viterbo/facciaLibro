package com.example.facciaLibro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.facciaLibro.entity.Indirizzo;
import com.example.facciaLibro.entity.Post;
import com.example.facciaLibro.entity.Telefono;
import com.example.facciaLibro.entity.Utente;
import com.example.facciaLibro.repository.TelefonoRepository;

@Service
public class TelefonoService {

	@Autowired
	TelefonoRepository telefonoRepository;

	public List<Telefono> creaTelefono(Utente utente) {
		List<Telefono> telefoniSalvati = new ArrayList<>();

		for (Telefono numeroDaSalvare : utente.getTelefono()) {

			if (!numeroDaSalvare.getNumero().equalsIgnoreCase("")) {
				telefonoRepository.save(numeroDaSalvare);
				telefoniSalvati.add(numeroDaSalvare);
			}
		}
		return telefoniSalvati;
	}
}
