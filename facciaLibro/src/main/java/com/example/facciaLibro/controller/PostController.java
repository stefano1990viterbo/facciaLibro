package com.example.facciaLibro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.facciaLibro.entity.Post;
import com.example.facciaLibro.entity.Utente;
import com.example.facciaLibro.service.PostService;

@Controller
@RequestMapping("/post")
public class PostController {

@Autowired
PostService postService;
	
	@GetMapping("/")
	public List<Post> getPost(Model model) {
		List<Post> listaPost = postService.leggiPost();
		System.out.println("Post: " + listaPost);
		return listaPost;		
	}
	
	
	@GetMapping("/new")
	public String nuovoPost() {
		return "/nuovo-post";
	}

//	@PostMapping("/")
//	public String createPost(Post post) {
//		postService.creaPost(post);
//		return "redirect:/facciaLibro/";
//	}
	
	@PostMapping("/")
	public String createPost(Post post,Utente utente) {
		postService.creaPost(post,utente);
		
		return "redirect:/facciaLibro/";
	}
}
