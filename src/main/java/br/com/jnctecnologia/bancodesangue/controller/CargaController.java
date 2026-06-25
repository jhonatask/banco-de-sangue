package br.com.jnctecnologia.bancodesangue.controller;

import br.com.jnctecnologia.bancodesangue.service.CargaJsonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/carga")
@RequiredArgsConstructor
public class CargaController {

    private final CargaJsonService cargaJsonService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void cargaJson(@RequestParam("file") MultipartFile file) throws IOException {
        cargaJsonService.carregarDados(file);
    }

}
