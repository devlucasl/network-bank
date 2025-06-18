package com.networkbank.br;

import java.math.BigDecimal;

public class SaldoRespostaDTO {
    private String nome;
    private BigDecimal saldo;

    public SaldoRespostaDTO(String nome, BigDecimal saldo) {
        this.nome = nome;
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }
}
