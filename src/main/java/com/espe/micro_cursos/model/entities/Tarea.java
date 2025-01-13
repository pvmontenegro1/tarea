package com.espe.micro_cursos.model.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
@Table(name = "tarea")

public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    @NotBlank(message = "El título no puede estar vacío")
    @Size(min = 3, max = 20, message = "El título debe tener entre 3 y 20 caracteres")
    private String titulo;

    @Column(nullable = false)
    @NotBlank(message = "La descripción no puede estar vacía")
    @Size(min = 10, max = 100, message = "La descripción debe tener entre 10 y 100 caracteres")
    private String descripcion;

    @Column(nullable = false)
    @Min(value = 1, message = "La prioridad mínima es 1")
    @Max(value = 5, message = "La prioridad máxima es 5")
    private int prioridad;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "La fecha de entrega no puede ser en el pasado")
    private LocalDate fechaEntrega;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
}
