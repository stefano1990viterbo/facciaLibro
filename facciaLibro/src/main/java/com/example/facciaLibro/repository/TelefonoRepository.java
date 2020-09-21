package com.example.facciaLibro.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.example.facciaLibro.entity.Telefono;

@Repository
public interface TelefonoRepository extends CrudRepository<Telefono, Long>{

//	List<Telefono> save(List<Telefono> telefono);

	
}
