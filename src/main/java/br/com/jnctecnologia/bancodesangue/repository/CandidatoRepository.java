package br.com.jnctecnologia.bancodesangue.repository;

import br.com.jnctecnologia.bancodesangue.entity.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CandidatoRepository extends JpaRepository<Candidato,Long> {

    boolean existsByCpf(String cpf);

    @Query("SELECT c.cpf FROM Candidato c")
    List<String> findAllCpfs();
}
