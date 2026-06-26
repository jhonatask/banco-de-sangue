package br.com.jnctecnologia.bancodesangue.controller;

import br.com.jnctecnologia.bancodesangue.dto.projection.*;
import br.com.jnctecnologia.bancodesangue.service.BancoDeSangueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/relatorios")
@RequiredArgsConstructor
public class BancoDeSangueController {

    private final BancoDeSangueService bancoDeSangueService;

    @GetMapping("/candidatos-por-estado")
    public ResponseEntity<List<CandidatosPorEstadoProjection>> candidatosPorEstado() {
        return ResponseEntity.ok(bancoDeSangueService.candidatosPorEstado());
    }

    @GetMapping("/imc-por-faixa-etaria")
    public ResponseEntity<List<ImcPorFaixaEtariaProjection>> imcPorFaixaEtaria() {
        return ResponseEntity.ok(bancoDeSangueService.imcMedioPorFaixaEtaria());
    }

    @GetMapping("/obesos-por-sexo")
    public ResponseEntity<List<ObesosPorSexoProjection>> obesosPorSexo() {
        return ResponseEntity.ok(bancoDeSangueService.obesosPorSexo());
    }

    @GetMapping("/media-idade-por-tipo-sanguineo")
    public ResponseEntity<List<MediaIdadePorTipoSanguineoProjection>> mediaIdadePorTipoSanguineo() {
        return ResponseEntity.ok(bancoDeSangueService.mediaIdadePorTipoSanguineo());
    }

    @GetMapping("/doadores-por-receptor")
    public ResponseEntity<List<DoadoresPorReceptorProjection>> doadoresPorReceptor() {
        return ResponseEntity.ok(bancoDeSangueService.doadoresPorReceptor());
    }
}
