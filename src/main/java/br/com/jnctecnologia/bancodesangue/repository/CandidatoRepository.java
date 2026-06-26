package br.com.jnctecnologia.bancodesangue.repository;

import br.com.jnctecnologia.bancodesangue.dto.projection.*;
import br.com.jnctecnologia.bancodesangue.entity.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {

    boolean existsByCpf(String cpf);

    @Query("SELECT c.cpf FROM Candidato c")
    List<String> findAllCpfs();

    @Query("""
            SELECT c.estado AS estado, COUNT(c) AS quantidade
            FROM Candidato c
            GROUP BY c.estado
            ORDER BY c.estado
            """)
    List<CandidatosPorEstadoProjection> findCandidatosPorEstado();

    @Query(value = """
            SELECT
                FLOOR(TIMESTAMPDIFF(YEAR, data_nascimento, CURDATE()) / 10) * 10 AS faixaInicio,
                AVG(peso / (altura * altura)) AS imcMedio
            FROM candidatos
            GROUP BY faixaInicio
            ORDER BY faixaInicio
            """, nativeQuery = true)
    List<ImcPorFaixaEtariaProjection> findImcMedioPorFaixaEtaria();

    @Query(value = """
            SELECT
                sexo,
                COUNT(*) AS total,
                SUM(CASE WHEN (peso / (altura * altura)) > 30 THEN 1 ELSE 0 END) AS obesos,
                (SUM(CASE WHEN (peso / (altura * altura)) > 30 THEN 1 ELSE 0 END) * 100.0 / COUNT(*)) AS percentual
            FROM candidatos
            GROUP BY sexo
            """, nativeQuery = true)
    List<ObesosPorSexoProjection> findObesosPorSexo();

    @Query(value = """
            SELECT
                tipo_sanguineo AS tipoSanguineo,
                AVG(TIMESTAMPDIFF(YEAR, data_nascimento, CURDATE())) AS mediaIdade
            FROM candidatos
            GROUP BY tipo_sanguineo
            ORDER BY tipo_sanguineo
            """, nativeQuery = true)
    List<MediaIdadePorTipoSanguineoProjection> findMediaIdadePorTipoSanguineo();

    @Query(value = """
            SELECT
                cs.receptor AS receptor,
                COUNT(c.id) AS totalDoadores
            FROM compatibilidade_sanguinea cs
            LEFT JOIN candidatos c
                ON c.tipo_sanguineo = cs.doador
                AND TIMESTAMPDIFF(YEAR, c.data_nascimento, CURDATE()) BETWEEN 16 AND 69
                AND c.peso > 50
            GROUP BY cs.receptor
            ORDER BY cs.receptor
            """, nativeQuery = true)
    List<DoadoresPorReceptorProjection> findDoadoresPorReceptor();
}
