package br.com.jnctecnologia.bancodesangue.repository;

import br.com.jnctecnologia.bancodesangue.entity.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatoRepository extends JpaRepository<Candidato,Integer> {
}
