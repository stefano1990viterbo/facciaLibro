package com.example.facciaLibro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.facciaLibro.entity.Post;
import com.example.facciaLibro.entity.Utente;
import com.example.facciaLibro.repository.PostRepository;
import com.example.facciaLibro.repository.UtentiRepository;

@Service
public class PostService {

	@Autowired
	PostRepository postRepository;

	@Autowired
	UtentiRepository utentiRepository;
	
	

	public List<Post> leggiPost() {

		return (List<Post>) postRepository.findAll();
	}

	public void creaPost(Post post, Utente utenteConfrontare) {

		List<Utente> listaUtente = (List<Utente>) utentiRepository.findAll();
		List<Post> listaPost =  new ArrayList<>();
		
		
		
		for (Utente utenteAggiornare : listaUtente) {

			if (utenteConfrontare.getNome().equalsIgnoreCase(utenteAggiornare.getNome())
					&& utenteConfrontare.getCognome().equalsIgnoreCase(utenteAggiornare.getCognome())) {

				post.setIdUtente(utenteAggiornare.getId());
				post.setNomeUtente(utenteAggiornare.getNome());
				
				listaPost.add(post);				
				utenteAggiornare.setPost(listaPost);
				postRepository.save(post);
				

			}

		}

//		System.out.println("DEBUG post " +utenteConfrontare);
//		postRepository.save(post);

	}

	public List<Post> postByIdUtente(Long idUtente) {
		List<Post> postUtenteSelezionato= new ArrayList<>();
		postUtenteSelezionato= postRepository.findByIdUtente(idUtente);
		
		return  postUtenteSelezionato;
	}

}
