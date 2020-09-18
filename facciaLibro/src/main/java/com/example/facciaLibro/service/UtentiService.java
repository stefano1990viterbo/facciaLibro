package com.example.facciaLibro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.facciaLibro.entity.Indirizzo;
import com.example.facciaLibro.entity.Telefono;
import com.example.facciaLibro.entity.Utente;
import com.example.facciaLibro.repository.UtentiRepository;

@Service
public class UtentiService {
	
	
	@Autowired
	UtentiRepository utentiRepository;
	
	@Autowired
	IndirizzoService indirizzoService;
	
	@Autowired
	TelefonoService telefonoService;
	
	public void creaUtente(Utente utente) {
		
		
		
		
		if(utente.getIndirizzo()!=null) {
		utente.setIndirizzo(indirizzoService.associaIndirizzo(utente.getIndirizzo()));	
		}		
		
		
		List<Telefono> telefonoDaSalvare= utente.getTelefono();
		if(utente.getTelefono()!=null)
		{
			List<Telefono> telefonoSalvato= telefonoService.creaTelefono(telefonoDaSalvare);
			utente.setTelefono(telefonoSalvato);
		}
		utentiRepository.save(utente);
	}
	
	
	
	
	public List<Utente> leggiUtenti() {
		return (List<Utente>) utentiRepository.findAll();
	}
}
