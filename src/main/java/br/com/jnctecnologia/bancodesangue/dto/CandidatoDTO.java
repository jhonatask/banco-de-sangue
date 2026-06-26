package br.com.jnctecnologia.bancodesangue.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CandidatoDTO(
        String nome,
        String cpf,
        String sexo,
        String estado,
        String data_nasc,
        Double altura,
        Double peso,
        String tipo_sanguineo
) {
}
