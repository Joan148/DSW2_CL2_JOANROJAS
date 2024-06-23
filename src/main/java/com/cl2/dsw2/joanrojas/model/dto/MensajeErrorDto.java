package com.cl2.dsw2.joanrojas.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class MensajeErrorDto {
    private Integer codigoEstado;
    private Date fechaError;
    private String mensaje;
    private String descripcion;
}
