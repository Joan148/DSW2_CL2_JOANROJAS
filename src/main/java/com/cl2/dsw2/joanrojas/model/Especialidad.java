package com.cl2.dsw2.joanrojas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "especialidad")
@NoArgsConstructor
@AllArgsConstructor
public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idespecialidad;
    private String titulo;
    private String funcion;
    private Date fechgraduacion;

    @ManyToOne
    @JoinColumn(name = "idMedico", nullable = false)
    private Medico medico;
}
