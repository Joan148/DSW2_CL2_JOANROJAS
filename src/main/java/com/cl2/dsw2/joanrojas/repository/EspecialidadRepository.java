package com.cl2.dsw2.joanrojas.repository;

import com.cl2.dsw2.joanrojas.model.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad,Integer> {
}
