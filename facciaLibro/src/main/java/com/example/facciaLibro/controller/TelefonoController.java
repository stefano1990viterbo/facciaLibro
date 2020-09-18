package com.example.facciaLibro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.facciaLibro.entity.Indirizzo;
import com.example.facciaLibro.entity.Telefono;
import com.example.facciaLibro.service.IndirizzoService;
import com.example.facciaLibro.service.TelefonoService;

@Controller
@RequestMapping("/telefono")
public class TelefonoController {

	
	
	@Autowired
	TelefonoService telefonoService;

	@PostMapping("/")
	public String createTelefono(List<Telefono> telefono) {

		System.out.println("telefono "+telefono);
		telefonoService.creaTelefono(telefono);
		return "redirect:/telefono/";
	}
}
