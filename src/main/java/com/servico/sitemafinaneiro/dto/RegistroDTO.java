package com.servico.sitemafinaneiro.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RegistroDTO {
    private String nome;
    private String classificacao;
    private Double valor;
    private LocalDate dataDoObjeto;
    private boolean isReceita; // true para receita, false para despesa
}
