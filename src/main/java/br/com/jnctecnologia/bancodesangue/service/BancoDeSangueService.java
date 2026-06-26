package br.com.jnctecnologia.bancodesangue.service;

import br.com.jnctecnologia.bancodesangue.dto.projection.*;
import br.com.jnctecnologia.bancodesangue.repository.CandidatoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BancoDeSangueService {

    private final CandidatoRepository candidatoRepository;

    public List<CandidatosPorEstadoProjection> candidatosPorEstado() {
        return candidatoRepository.findCandidatosPorEstado();
    }

    public List<ImcPorFaixaEtariaProjection> imcMedioPorFaixaEtaria() {
        return candidatoRepository.findImcMedioPorFaixaEtaria();
    }

    public List<ObesosPorSexoProjection> obesosPorSexo() {
        return candidatoRepository.findObesosPorSexo();
    }

    public List<MediaIdadePorTipoSanguineoProjection> mediaIdadePorTipoSanguineo() {
        return candidatoRepository.findMediaIdadePorTipoSanguineo();
    }

    public List<DoadoresPorReceptorProjection> doadoresPorReceptor() {
        return candidatoRepository.findDoadoresPorReceptor();
    }
}
