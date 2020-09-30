package com.example.facciaLibro.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.facciaLibro.entity.Post;
import com.example.facciaLibro.entity.Utente;
import com.example.facciaLibro.service.FacciaLibroService;
import com.example.facciaLibro.service.PostService;
import com.example.facciaLibro.service.UtentiService;

@Controller
@RequestMapping("/facciaLibro")
public class FacciaLibroController {

	@Autowired
	UtentiService utentiService;
	@Autowired
	PostService postService;
	@Autowired
	FacciaLibroService facciaLibroService;

	@GetMapping("/")
	public List<Post> primaPagina(Model model) {

		// List<Post> primaPagina=facciaLibroService.primaPagina();
		// model.addAttribute("listaPost", primaPagina);

//	List<Utente> listaUtenti = utentiService.leggiUtenti();
//	model.addAttribute("listaUtenti", listaUtenti);

		List<Post> listaPost = postService.leggiPost();
		model.addAttribute("listaPost", listaPost);

		return listaPost;

	}

	@GetMapping("/{utenteCreazione}")
	public String show(@PathVariable long utenteCreazione, Model model) {

		Utente utenteSelezionato = utentiService.utenteFindById(utenteCreazione);
		model.addAttribute("utenteSelezionato", utenteSelezionato);
		return "dettagli-utente";
	}

}
