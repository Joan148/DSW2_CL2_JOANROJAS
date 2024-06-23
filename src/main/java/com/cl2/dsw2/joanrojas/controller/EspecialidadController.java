package com.cl2.dsw2.joanrojas.controller;

import com.cl2.dsw2.joanrojas.model.Especialidad;
import com.cl2.dsw2.joanrojas.model.Medico;
import com.cl2.dsw2.joanrojas.service.EspecialidadService;
import com.cl2.dsw2.joanrojas.service.MedicoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/especialidad")
public class EspecialidadController {

    private EspecialidadService especialidadService;

    @GetMapping("")
    public ResponseEntity<List<Especialidad>> listarEspecialidad(){
        List<Especialidad> especialidadList = new ArrayList<>(especialidadService.listarEspecialidades());
        if(especialidadList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(especialidadList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Especialidad> obtenerEspecialidadXId(
            @PathVariable Integer id){
        Especialidad especialidad = especialidadService
                .obtenerEspecialidadxId(id).orElseThrow(null);
        return new ResponseEntity<>(especialidad, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Especialidad> registrarEspecialidad(
            @RequestBody Especialidad especialidad
    ){
        return new ResponseEntity<>(
                especialidadService.guardarEspecialidad(especialidad), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Especialidad> actualizarEspecialidad(
            @PathVariable Integer id,
            @RequestBody Especialidad especialidad
    ){
        Especialidad newEspecialidad = especialidadService.obtenerEspecialidadxId(id)
                .orElseThrow(null);
        newEspecialidad.setTitulo(especialidad.getTitulo());
        newEspecialidad.setFuncion(especialidad.getFuncion());
        newEspecialidad.setFechgraduacion(especialidad.getFechgraduacion());
        return new ResponseEntity<>(
                especialidadService.guardarEspecialidad(newEspecialidad),
                HttpStatus.OK);
    }
}
