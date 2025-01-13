package com.espe.micro_cursos.controller;

import com.espe.micro_cursos.model.entities.Tarea;
import com.espe.micro_cursos.services.TareaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//ya se puede exponer los metodos con este comando
@RestController
@RequestMapping("/api/tarea")
public class TareaController {
    @Autowired
    private TareaService service;

    // Método privado para manejar la validación
    private ResponseEntity<?> validar(BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            result.getFieldErrors().forEach(
                    error -> errors.put(error.getField(), error.getDefaultMessage())
            );
            return ResponseEntity.badRequest().body(errors);
        }
        return null;
    }

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody Tarea tarea, BindingResult result) {
        // Reutilizamos la función validar
        ResponseEntity<?> errores = validar(result);
        if (errores != null) {
            return errores;
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(tarea));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@Valid @RequestBody Tarea tarea, BindingResult result, @PathVariable Long id) {
        // Reutilizamos la función validar
        ResponseEntity<?> errores = validar(result);
        if (errores != null) {
            return errores;
        }

        Optional<Tarea> tareaOptional = service.findById(id);
        if (tareaOptional.isPresent()) {
            Tarea tareaDB = tareaOptional.get();
            tareaDB.setTitulo(tarea.getTitulo());
            tareaDB.setDescripcion(tarea.getDescripcion());
            tareaDB.setPrioridad(tarea.getPrioridad());
            tareaDB.setFechaEntrega(tarea.getFechaEntrega());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(tareaDB));
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping
    public List<Tarea> listar(){
        return service.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Tarea> buscarPorId(@PathVariable Long id) {
        Optional<Tarea> tareaOptional = service.findById(id);
        if (tareaOptional.isPresent()) {
            return ResponseEntity.ok().body(tareaOptional.get());
        }
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Optional<Tarea> tareaOptional = service.findById(id);
        if(tareaOptional.isPresent()) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
        }
    }


