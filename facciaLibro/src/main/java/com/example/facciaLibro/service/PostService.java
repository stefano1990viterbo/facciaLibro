package com.example.facciaLibro.service;

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

	public void creaPost(Post post,Utente utenteConfrontare) {
		
		List<Utente> listaUtente= (List<Utente>) utentiRepository.findAll();
		
		for (Utente utenteAggiornare: listaUtente ) {
			
			if(utenteConfrontare.getNome().equalsIgnoreCase(utenteAggiornare.getNome()) &&
			utenteConfrontare.getCognome().equalsIgnoreCase(utenteAggiornare.getCognome())){
				
				System.out.println("DEBUG ID "+ utenteAggiornare.getId());
				
				post.setIdUtente(utenteAggiornare.getId());
				postRepository.save(post);
				
			}
			
			
		}
			
		
//		System.out.println("DEBUG post " +utenteConfrontare);
//		postRepository.save(post);
		
	}

}
