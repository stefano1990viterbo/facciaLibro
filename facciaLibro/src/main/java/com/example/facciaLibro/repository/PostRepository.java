package com.example.facciaLibro.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.facciaLibro.entity.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

	List<Post> findByIdUtente(Long idUtente);

	
	
	

}
