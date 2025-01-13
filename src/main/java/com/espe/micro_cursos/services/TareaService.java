package com.espe.micro_cursos.services;

import com.espe.micro_cursos.model.entities.Tarea;

import java.util.List;
import java.util.Optional;

//aqui se definene lo metodos a utlizar
public interface TareaService {
    List<Tarea> findAll();
    Optional<Tarea> findById(long Id);
    Tarea save(Tarea tarea); //crear registros o existentes (actualizar)
    void deleteById(long Id);
}
