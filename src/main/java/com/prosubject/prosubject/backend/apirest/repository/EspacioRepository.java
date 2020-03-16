package com.prosubject.prosubject.backend.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prosubject.prosubject.backend.apirest.model.Espacio;
// A quitar capacidad de espacio he quitado (jesus) estacondicion dde la primera query :e.capacidad > e.alumnos.size AND
@Repository
public interface EspacioRepository extends JpaRepository<Espacio, Long> {
	@Query("select distinct(e) from espacios e inner join e.asignatura asig "
			+ "inner join asig.curso cur "
			+ "inner join asig.grados gra "
			+ "inner join gra.facultad facul "
			+ "inner join facul.universidad uni "
			+ "where uni.nombre=?1 AND facul.nombre=?2 AND cur.nombre=?3 AND asig.nombre=?4")
	List<Espacio> findDisponibles(String universidad, String facultad, String curso, String asignatura);
	
	
	
	@Query("select e from espacios e where e.profesor.id=?1")
	List<Espacio> espaciosDeUnProfesor(Long id);
	
	//Jesus:Query comentada debido a los cambios en el modelo 
	@Query("select h.espacio from horario h  join h.alumnos alum where alum.id=?1")
	List<Espacio> espaciosDeUnAlumno(Long id);
	
	
	
}
