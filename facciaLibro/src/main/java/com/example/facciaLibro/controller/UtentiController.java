package com.example.facciaLibro.controller;

import java.util.List;

import javax.jws.WebParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.facciaLibro.entity.Indirizzo;
import com.example.facciaLibro.entity.Utente;
import com.example.facciaLibro.service.IndirizzoService;
import com.example.facciaLibro.service.UtentiService;

@Controller
@RequestMapping("/utente")
public class UtentiController {
	@Autowired
	UtentiService utentiService;

	@Autowired
	IndirizzoService indirizzoService;


	@GetMapping("/")
	public List<Utente> getUtenti(Model model, @WebParam String nome) {
		List<Utente> listaUtenti;
		listaUtenti = listaFiltrata(nome);
		model.addAttribute("listaUtenti", listaUtenti);
		return listaUtenti;
	}

	

	@GetMapping("/new")
	public String nuovoUtente() {
		return "/nuovo-utente";
	}
	
	
	@GetMapping("/{id}/edit")
	public String edit(@PathVariable Long id, Model model) {
		Utente utenteDaModificare = utentiService.utenteFindById(id);
		model.addAttribute("utenteDaModificare", utenteDaModificare);
		return"edit-utente";
	}
	

	@PostMapping("/")
	public String createUtente(Utente utente) {
		utentiService.creaUtente(utente);
		return "redirect:/utente/";
	}

	@GetMapping("/{id}")
	public String show(@PathVariable Long id, Model model) {

		Utente utenteSelezionato = utentiService.utenteFindById(id);
		model.addAttribute("utenteSelezionato", utenteSelezionato);

		return "dettagli-utente";
	}
	
	@PostMapping("/{id}")
	public String update(Utente utente) {
		utentiService.creaUtente(utente);
		return "redirect:/utente/";
	}
	
	private List<Utente> listaFiltrata(String nome) {
		if (nome == null || nome.equalsIgnoreCase("")) {
			return utentiService.leggiUtenti();
		} else {
			return utentiService.leggiUtentiFiltratiPerNome(nome);
		}
	}
}
