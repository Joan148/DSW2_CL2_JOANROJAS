package com.cl2.dsw2.joanrojas.service;

import com.cl2.dsw2.joanrojas.model.Especialidad;
import com.cl2.dsw2.joanrojas.repository.EspecialidadRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class EspecialidadService implements IEspecialidadService{
    private EspecialidadRepository especialidadRepository;


    @Override
    public List<Especialidad> listarEspecialidades() {
        return especialidadRepository.findAll();
    }

    @Override
    public Especialidad guardarEspecialidad(Especialidad especialidad) {
        return especialidadRepository.save(especialidad);
    }

    @Override
    public Optional<Especialidad> obtenerEspecialidadxId(Integer id) {
        Optional<Especialidad> especialidad
                = especialidadRepository.findById(id);
        if(especialidad.isEmpty()){
            return Optional.empty();
        }
        return especialidad;
    }
}
