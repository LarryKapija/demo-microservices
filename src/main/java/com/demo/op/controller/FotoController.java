package com.demo.op.controller;

import com.demo.op.data.SecuenciaFotoRepository;
import com.demo.op.data.entity.SecuenciaFoto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

@Controller
public class FotoController {

    @Value("${rutaFotos}")
    String rutaFotos;

    @Autowired
    SecuenciaFotoRepository secuenciaFotoRepository;

    final String DEFAULT_EXTENSION = "jpg";
    final String DEFAULT_PREFIX = "FOTO-REPORTE";
    final String[] validExtensions = new String[]{"JPG", "JPEG"};

    @RequestMapping(value = "/subir-foto", method = RequestMethod.POST)
    @ResponseBody
    public String subirFoto(@RequestParam("foto") MultipartFile multipartFile) throws IOException {
        String extension = extraerExtension(multipartFile.getOriginalFilename());
        Long secuenciaFoto = generarSecuencia();


        if(Arrays.stream(validExtensions)
                .noneMatch(validExt -> validExt.equals(extension.toUpperCase())))
            return "";

        File foto = new File(getFilePath(secuenciaFoto));
        while (foto.exists()) {
            secuenciaFoto = generarSecuencia();
            foto = new File(getFilePath(secuenciaFoto));
        }

        multipartFile.transferTo(foto);
        return "/descargar-foto/"+secuenciaFoto;
    }

    private String getFilePath(Long secuenciaFoto) {
        return rutaFotos+DEFAULT_PREFIX+"-"+secuenciaFoto+"."+DEFAULT_EXTENSION;
    }

    @RequestMapping(value = "descargar-foto/{secuencia-foto}", method = RequestMethod.GET,
    produces = MediaType.IMAGE_JPEG_VALUE)
    public void descargarFoto(HttpServletResponse response, @PathVariable("secuencia-foto") Integer secuenciaFoto) throws IOException {

        File foto = new File(rutaFotos+DEFAULT_PREFIX+"-"+secuenciaFoto+"."+DEFAULT_EXTENSION);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        try(FileInputStream inputStream = new FileInputStream(foto)){
            StreamUtils.copy(inputStream, response.getOutputStream());
        }
    }

    private String extraerExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf('.')+1);
    }

    private Long generarSecuencia(){
        return secuenciaFotoRepository.save(new SecuenciaFoto()).getId();
    }

}
