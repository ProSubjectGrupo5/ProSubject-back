package com.prosubject.prosubject.backend.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prosubject.prosubject.backend.apirest.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long>  {
	
	@Query("select c from Curso c where c.id=?1")
	Curso findOneById(long id);
	
	

}
