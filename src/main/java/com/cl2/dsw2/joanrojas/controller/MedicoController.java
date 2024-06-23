package com.cl2.dsw2.joanrojas.controller;

import com.cl2.dsw2.joanrojas.model.Medico;
import com.cl2.dsw2.joanrojas.service.MedicoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/medico")
public class MedicoController {

    private MedicoService medicoService;

    @GetMapping("")
    public ResponseEntity<List<Medico>> listarMedicos(){
        List<Medico> medicoList = new ArrayList<>(medicoService.listarMedicos());
        if(medicoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(medicoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medico> obtenerMedicoXId(
            @PathVariable Integer id){
        Medico medico = medicoService
                .obtenerMedicoxId(id).orElseThrow(null);
        return new ResponseEntity<>(medico, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Medico> registrarMedico(
            @RequestBody Medico medico
    ){
        return new ResponseEntity<>(
                medicoService.guardarMedico(medico), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medico> actualizarMedico(
            @PathVariable Integer id,
            @RequestBody Medico medico
    ){
        Medico newMedico = medicoService.obtenerMedicoxId(id)
                .orElseThrow(null);
        newMedico.setNommedico(medico.getNommedico());
        newMedico.setApemedico(medico.getApemedico());
        newMedico.setFechnacmedico(medico.getFechnacmedico());
        return new ResponseEntity<>(
                medicoService.guardarMedico(newMedico),
                HttpStatus.OK);
    }
}
