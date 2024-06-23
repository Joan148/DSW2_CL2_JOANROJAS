package com.cl2.dsw2.joanrojas.service;

import com.cl2.dsw2.joanrojas.model.Especialidad;
import com.cl2.dsw2.joanrojas.model.Medico;

import java.util.List;
import java.util.Optional;

public interface IEspecialidadService {
    List<Especialidad> listarEspecialidades();
    Especialidad guardarEspecialidad(Especialidad especialidad);
    Optional<Especialidad> obtenerEspecialidadxId(Integer id);
}
