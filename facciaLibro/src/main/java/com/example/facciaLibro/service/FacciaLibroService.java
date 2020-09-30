package com.example.facciaLibro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.facciaLibro.entity.Post;
import com.example.facciaLibro.entity.Utente;

import javassist.expr.NewArray;

@Service
public class FacciaLibroService {
	@Autowired
	UtentiService utentiService;
@Autowired
PostService postService;
	


}
