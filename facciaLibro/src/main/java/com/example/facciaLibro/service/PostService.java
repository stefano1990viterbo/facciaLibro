package com.example.facciaLibro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.facciaLibro.entity.Post;
import com.example.facciaLibro.entity.Utente;
import com.example.facciaLibro.repository.PostRepository;

@Service
public class PostService {
	
	
	@Autowired
	PostRepository postRepository;

	public List<Post> leggiPost() {
		
		return (List<Post>) postRepository.findAll();
	}

	public void creaPost(Post post) {
		postRepository.save(post);
	}
	

}
