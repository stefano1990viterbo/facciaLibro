package com.example.facciaLibro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.facciaLibro.entity.Post;
import com.example.facciaLibro.entity.Utente;

@Service
public class FacciaLibroService {
	@Autowired
	UtentiService utentiService;
@Autowired
PostService postService;
	

public List<Utente> primaPagina() {
List<Utente> listaUtenti = utentiService.leggiUtenti();
	List<Post> listaPost=postService.leggiPost();
	System.out.println("Utenti: " + listaUtenti);
	System.out.println("Post:" +listaPost);
	return listaUtenti;
}
}
