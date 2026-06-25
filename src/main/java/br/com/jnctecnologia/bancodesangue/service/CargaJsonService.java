package br.com.jnctecnologia.bancodesangue.service;

import br.com.jnctecnologia.bancodesangue.dto.CandidatoDto;
import br.com.jnctecnologia.bancodesangue.entity.Candidato;
import br.com.jnctecnologia.bancodesangue.mapper.CandidatoMapper;
import br.com.jnctecnologia.bancodesangue.repository.CandidatoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CargaJsonService {

    final ObjectMapper mapper;
    final CandidatoMapper candidatoMapper;
    final CandidatoRepository candidatoRepository;

    public void carregarDados(MultipartFile file) throws IOException {
        List<CandidatoDto> dados = mapper.readValue(
                file.getInputStream(),
                new TypeReference<>() {
                }
        );
        Set<String> cpfsExistentes = new HashSet<>(candidatoRepository.findAllCpfs());
        List<Candidato> candidatos = dados.stream()
                .filter(dado -> !cpfsExistentes.contains(dado.cpf()))
                .map(candidatoMapper::toEntity).toList();

        if (!candidatos.isEmpty()) {
            candidatoRepository.saveAll(candidatos);
        }

    }
}
