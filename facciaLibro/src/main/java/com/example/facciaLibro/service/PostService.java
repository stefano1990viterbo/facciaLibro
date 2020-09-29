package com.example.facciaLibro.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

//	public List<Post> leggiPost() {
//
//		return (List<Post>) postRepository.findAll();
//	
//				
//	}

	public List<Post> leggiPost() {

		List<Post> listaPost2 = (List<Post>) postRepository.findAll();
		// listaPost2.sort((o2, o1) -> o1.getId().compareTo((o2.getId())));
		listaPost2.sort((o2, o1) -> o1.getDataCreazione().compareTo(o2.getDataCreazione()));
		return listaPost2;
	}

//	public  List<Post> leggiPost(List<Post> listaPost) {
//		List<Post> listaPost2= (List<Post>) postRepository.findAll();
//		listaPost2.sort((o1, o2) -> o1.getDataCreazione().compareTo((o2.getDataCreazione())));	
//		return listaPost2;
//		
//	}

	public void creaPost(Post post, Utente utenteConfrontare) {

		List<Utente> listaUtente = (List<Utente>) utentiRepository.findAll();
		List<Post> listaPost = new ArrayList<>();

		for (Utente utenteAggiornare : listaUtente) {

			if (utenteConfrontare.getNome().equalsIgnoreCase(utenteAggiornare.getNome())
					&& utenteConfrontare.getCognome().equalsIgnoreCase(utenteAggiornare.getCognome())) {

				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				post.setDataFormattata(post.getDataCreazione().format(formatter));

				post.setIdUtente(utenteAggiornare.getId());
				post.setNomeUtente(utenteAggiornare.getNome());

				listaPost.add(post);
				utenteAggiornare.setPost(listaPost);
				postRepository.save(post);

			}

		}

	}

	public List<Post> postByIdUtente(Long idUtente) {
		List<Post> postUtenteSelezionato = new ArrayList<>();
		postUtenteSelezionato = postRepository.findByIdUtente(idUtente);
		
		postUtenteSelezionato.sort((o2, o1) -> o1.getDataCreazione().compareTo(o2.getDataCreazione()));

		return postUtenteSelezionato;
	}

}
