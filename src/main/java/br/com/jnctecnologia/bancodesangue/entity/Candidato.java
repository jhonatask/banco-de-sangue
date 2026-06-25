package br.com.jnctecnologia.bancodesangue.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "candidatos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Candidato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    @Column(unique = true)
    private String cpf;
    private String sexo;
    private String estado;
    private Double altura;
    private Double peso;
    private String tipoSanguineo;
    private LocalDate dataNascimento;
}
