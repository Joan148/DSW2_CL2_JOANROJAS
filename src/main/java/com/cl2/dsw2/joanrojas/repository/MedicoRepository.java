package com.cl2.dsw2.joanrojas.repository;

import com.cl2.dsw2.joanrojas.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico,Integer> {
}
