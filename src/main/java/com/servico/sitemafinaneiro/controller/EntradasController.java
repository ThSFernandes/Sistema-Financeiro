package com.servico.sitemafinaneiro.controller;

import com.servico.sitemafinaneiro.dto.RegistroDTO; // Importar o DTO
import com.servico.sitemafinaneiro.entidades.Registro; // Importar a entidade
import com.servico.sitemafinaneiro.servico.ServicoDeRegistro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate; // Importar LocalDate

@RestController
@RequestMapping("/entradas")
public class EntradasController {

    @Autowired
    private ServicoDeRegistro registro;

    @PostMapping
    public ResponseEntity<Registro> registrarEntrada(@RequestBody RegistroDTO registroDTO) {
        Registro novoRegistro = new Registro();
        novoRegistro.setNome(registroDTO.getNome());
        novoRegistro.setClassificacao(registroDTO.getClassificacao());
        novoRegistro.setValor(registroDTO.getValor());
        novoRegistro.setDataDoObeto(registroDTO.getDataDoObjeto());
        novoRegistro.setDataDeRegistro(LocalDate.now());
        novoRegistro.setReceita(registroDTO.isReceita()); // Ajustar conforme sua lógica

        Registro salvo = registro.salvarRegistro(novoRegistro);
        return new ResponseEntity<>(salvo, HttpStatus.CREATED);
    }

    @GetMapping("/receita")
    public double receita() {
        return registro.calcularReceita();
    }

    @GetMapping("/despesas")
    public double despesas() {
        return registro.calcularDespesa();
    }

    @GetMapping("/saldo")
    public double saldo() {
        return registro.calularSaldo();
    }
}
