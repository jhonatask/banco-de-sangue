package br.com.jnctecnologia.bancodesangue.mapper;

import br.com.jnctecnologia.bancodesangue.dto.CandidatoDTO;
import br.com.jnctecnologia.bancodesangue.entity.Candidato;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CandidatoMapper {

    @Mapping(
            target = "dataNascimento",
            source = "data_nasc",
            dateFormat = "dd/MM/yyyy"
    )
    @Mapping(
            target = "tipoSanguineo",
            source = "tipo_sanguineo"
    )
    Candidato toEntity(CandidatoDTO dto);
}