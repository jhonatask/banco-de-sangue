package br.com.jnctecnologia.bancodesangue.dto;

public record CandidatoDto(
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
