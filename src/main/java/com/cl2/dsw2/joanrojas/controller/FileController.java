package com.cl2.dsw2.joanrojas.controller;

import com.cl2.dsw2.joanrojas.model.dto.ArchivoDto;
import com.cl2.dsw2.joanrojas.service.FileService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/files")
public class FileController {

    private FileService fileService;

    @PostMapping("")
    public ResponseEntity<ArchivoDto> subirVariosArchivos(
            @RequestParam("files") List<MultipartFile> multipartFileList) throws Exception {
        if (multipartFileList.size() != 3) {
            throw new Exception("Debe subir exactamente tres archivos.");
        }
        fileService.guardarArchivos(multipartFileList);
        return new ResponseEntity<>(ArchivoDto.builder().mensaje("Archivos subidos correctamente").build(), HttpStatus.OK);
    }
}
