package com.example.facciaLibro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.facciaLibro.entity.Indirizzo;
import com.example.facciaLibro.entity.Utente;
import com.example.facciaLibro.service.IndirizzoService;
import com.example.facciaLibro.service.UtentiService;


	@Controller
	@RequestMapping("/indirizzo")
	public class IndirizzoController {
		@Autowired
		IndirizzoService indirizzoService;

		@PostMapping("/")
		public String createIndirizzo(Indirizzo indirizzo) {
			indirizzoService.associaIndirizzo(indirizzo);
			return "redirect:/indirizzo/";
		}
		
		
//		@GetMapping("/")
//		public List<Utente> getUtenti(Model model) {
//			List<Utente> listaUtenti = utentiService.leggiUtenti();
//			System.out.println("Utenti: " + listaUtenti);
//			return listaUtenti;		
//		}
		
//		@GetMapping("/new")
//		public String nuovoUtente() {
//			return "/nuovo-utente";
//		}
	}
