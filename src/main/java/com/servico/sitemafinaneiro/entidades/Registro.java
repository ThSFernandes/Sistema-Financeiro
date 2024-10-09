package com.servico.sitemafinaneiro.entidades;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Table(name = "agendaFinanceira")

public class Registro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "Nome", nullable = false)
    private String nome;

    @Column(name = "Classificao", nullable = false)
    private String classificacao;

    @Column(name = "Valor", nullable = false)
    private Double valor;

    @Column(name = "DataDeCadastro", nullable = false, updatable = false)
    private LocalDate dataDeCadastro;

    @CreatedDate
    @Column(name = "DataDeRegistro")
    private LocalDate dataDeRegistro;



}
