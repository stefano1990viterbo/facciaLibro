package com.example.facciaLibro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	public List<Utente> getUtenti(Model model) {
		List<Utente> listaUtenti = utentiService.leggiUtenti();
		model.addAttribute("listaUtenti", listaUtenti);
		System.out.println("Utenti: " + listaUtenti);
		return listaUtenti;		
	}
	
	@GetMapping("/new")
	public String nuovoUtente() {
		return "/nuovo-utente";
	}

	@PostMapping("/")
	public String createUtente(Utente utente) {
		utentiService.creaUtente(utente);
		return "redirect:/utente/";
	}
}
