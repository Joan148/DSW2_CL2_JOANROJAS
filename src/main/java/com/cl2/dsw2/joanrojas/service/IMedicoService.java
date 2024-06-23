package com.cl2.dsw2.joanrojas.service;

import com.cl2.dsw2.joanrojas.model.Medico;

import java.util.List;
import java.util.Optional;

public interface IMedicoService {
    List<Medico> listarMedicos();
    Medico guardarMedico(Medico medico);
    Optional<Medico> obtenerMedicoxId(Integer id);
}
