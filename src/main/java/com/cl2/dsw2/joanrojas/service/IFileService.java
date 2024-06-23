package com.cl2.dsw2.joanrojas.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IFileService {

    void guardarArchivo(MultipartFile archivo) throws Exception;

    void guardarArchivos(List<MultipartFile> archivosList) throws Exception;
    void validarExtension(String nombreArchivo) throws Exception;

    void validarTamano(MultipartFile archivo) throws Exception;

}
