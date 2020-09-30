package com.example.facciaLibro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.facciaLibro.entity.Indirizzo;
import com.example.facciaLibro.entity.Post;
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
	@Autowired
	PostService postService;

//	@Autowired
//	Model model;

	public Utente utenteFindById(Long id) {

		Utente utenteSelezionato = utentiRepository.findById(id).get();
		List<Post> postUtente = postService.postByIdUtente(utenteSelezionato);

		utenteSelezionato.setPost(postUtente);

		return utenteSelezionato;
	}

	public String creaUtente(Utente utente) {

		if (controlloUtenteUguale(utente) == 0) {
			controlloIndirizzo(utente);
			controlloTelefono(utente);
			utentiRepository.save(utente);
			return null;
		} else {

			System.out.println("c'è gia un utente con queste credenziali");
			return "redirect:/errore/";

		}
	}

//	public int controlloUtenteUguale(Utente utente) {
//		int i = 0;
//		for (Utente controllo : leggiUtenti()) {
//			if (utente.getNome().equalsIgnoreCase(controllo.getNome())
//					&& utente.getCognome().equalsIgnoreCase(controllo.getCognome())) {
//				i++;
//				break;
//			}
//		}
//		
//		return i;
//	}
	public int controlloUtenteUguale(Utente utente) {
		int i = 0;
		for (Utente controllo : leggiUtenti()) {
			if (utente.equals(controllo)) {
				i++;
				break;
			}
		}

		return i;
	}

	public void controlloIndirizzo(Utente utente) {
		if (utente.getIndirizzo() != null) {
			utente.setIndirizzo(indirizzoService.associaIndirizzo(utente.getIndirizzo()));
		}
	}

	public void controlloTelefono(Utente utente) {
		System.out.println("utente telefono " + utente.getTelefono());
		if (utente.getTelefono() != null) {
			utente.setTelefono(telefonoService.creaTelefono(utente));

		}

	}

	public List<Utente> leggiUtenti() {

		return (List<Utente>) utentiRepository.findAll();
	}

	public List<Utente> leggiUtentiFiltratiPerNome(String nome) {

		return (List<Utente>) utentiRepository.findByNome(nome);
	}
}
