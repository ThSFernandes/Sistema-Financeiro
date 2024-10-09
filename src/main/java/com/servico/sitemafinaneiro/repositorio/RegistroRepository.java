package com.servico.sitemafinaneiro.repositorio;

import com.servico.sitemafinaneiro.entidades.Registro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistroRepository extends JpaRepository<Registro, Long> {

    List<Registro> findByIsReceitaTrue();

    List<Registro> findByIsReceitaFalse();
}
