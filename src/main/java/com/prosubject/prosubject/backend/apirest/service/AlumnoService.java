package com.prosubject.prosubject.backend.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prosubject.prosubject.backend.apirest.model.Alumno;
import com.prosubject.prosubject.backend.apirest.repository.AlumnoRepository;

@Service
public class AlumnoService {
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	
	public Alumno create() {
		final Alumno a = new Alumno();
		return a;
	}
	
	public List<Alumno> findAll() {
		return this.alumnoRepository.findAll();
	}
	
	public Alumno findOne(final long alumnoId) {
		return this.alumnoRepository.findById(alumnoId).get();
	}
	

	public Alumno save(final Alumno a) {
		
	   Alumno saved = this.alumnoRepository.save(a);

		return saved;
	}
	
}
