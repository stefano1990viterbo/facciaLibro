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
public List<Utente> primaPagina(Model model) {

	List<Utente> primaPagina=facciaLibroService.primaPagina();

	List<Utente> listaUtenti = utentiService.leggiUtenti();
	List<Post> listaPost = postService.leggiPost();
	model.addAttribute("listaUtenti", listaUtenti);
	model.addAttribute("listaPost", listaPost);

	return primaPagina;
	
}

@GetMapping("/{idUtente}")
public String show(@PathVariable Long idUtente, Model model) {
	List<Post> postUtente = new ArrayList<Post>();
	Utente utenteSelezionato = utentiService.utenteFindById(idUtente);
	postUtente = postService.postByIdUtente(idUtente);
	for(Post lista: postUtente) {
		System.out.println("DEBUG LISTA "+lista);
	}
	
	model.addAttribute("listaPost", postUtente);
	model.addAttribute("utenteSelezionato", utenteSelezionato);
	return "dettagli-utente";
}

}
