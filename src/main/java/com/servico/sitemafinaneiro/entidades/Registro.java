package com.servico.sitemafinaneiro.entidades;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Table(name = "controle-financeiro")
@EntityListeners(AuditingEntityListener.class) // Necessário para @CreatedDate funcionar
public class Registro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Usar IDENTITY para PostgreSQL
    private int id;

    @NonNull
    @Column(name = "nome", nullable = false)
    private String nome;

    @NonNull
    @Column(name = "classificacao", nullable = false)
    private String classificacao;

    @NonNull
    @Column(name = "valor", nullable = false)
    private Double valor;

    @NonNull
    @Column(name = "data", nullable = false)
    private LocalDate dataDoObeto;

    @CreatedDate
    @Column(name = "data_de_registro", updatable = false)
    private LocalDate dataDeRegistro;

    @NonNull
    @Column(name = "is_ganho", nullable = false)
    private boolean isReceita;
}
