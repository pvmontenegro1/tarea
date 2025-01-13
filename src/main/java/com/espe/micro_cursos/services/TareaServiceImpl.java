package com.espe.micro_cursos.services;

import com.espe.micro_cursos.model.entities.Tarea;
import com.espe.micro_cursos.repositories.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TareaServiceImpl implements TareaService {
    @Autowired
    private TareaRepository repository;


    @Override
    public List<Tarea> findAll() {
        return (List<Tarea>) repository.findAll();
    }

    @Override
    public Optional<Tarea> findById(long Id) {
        return repository.findById(Id);
    }

    @Override
    public Tarea save(Tarea tarea) {
        return repository.save(tarea);
    }

    @Override
    public void deleteById(long Id) {
        repository.deleteById(Id);

    }

}
