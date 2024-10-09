package com.servico.sitemafinaneiro.servico;

import com.servico.sitemafinaneiro.entidades.Registro;
import com.servico.sitemafinaneiro.repositorio.RegistroRepository; // Importar o repositório
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoDeRegistro {

    @Autowired
    private RegistroRepository registroRepository; // Supondo que você tenha um repositório

    // Método para salvar um novo registro
    public Registro salvarRegistro(Registro registro) {
        return registroRepository.save(registro);
    }

    public double calcularReceita() {
        // Lógica para calcular a receita total
        return registroRepository.findByIsReceitaTrue().stream()
                .mapToDouble(Registro::getValor)
                .sum();
    }

    public double calcularDespesa() {
        // Lógica para calcular a despesa total
        return registroRepository.findByIsReceitaFalse().stream()
                .mapToDouble(Registro::getValor)
                .sum();
    }

    public double calularSaldo() {
        // Lógica para calcular o saldo (receita - despesa)
        double receita = calcularReceita();
        double despesa = calcularDespesa();
        return receita - despesa;
    }
}
