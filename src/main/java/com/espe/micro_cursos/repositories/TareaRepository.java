package com.espe.micro_cursos.repositories;

import com.espe.micro_cursos.model.entities.Tarea;
import org.springframework.data.repository.CrudRepository;

public interface TareaRepository extends CrudRepository<Tarea, Long> {
}
