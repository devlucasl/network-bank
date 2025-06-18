package com.networkbank.br.Service;

import com.networkbank.br.Entity.Conta;
import com.networkbank.br.Entity.Transacao;
import com.networkbank.br.Enums.TipoTransacao;
import com.networkbank.br.Repository.ContaRepository;
import com.networkbank.br.Repository.TransacaoRepository;
import com.networkbank.br.SaldoRespostaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class ContaService {

    @Autowired
    protected ContaRepository contaRepo;

    @Autowired
    protected TransacaoRepository transacaoRepo;

    public void depositarPorCpf(String cpf, BigDecimal valor) {
        Conta conta = contaRepo.findByClienteCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Conta não encontrada para CPF: " + cpf));

        conta.setSaldo(conta.getSaldo().add(valor));

        Transacao t = new Transacao();
        t.setContaOrigem(conta);
        t.setTipoTransacao(TipoTransacao.DEPOSITO);
        t.setValor(valor);
        t.setDataHora(LocalDateTime.now());
        t.setDescricao("Depósito por CPF");

        transacaoRepo.save(t);
        contaRepo.save(conta);
    }

    public String buscarNumeroContaPorCpf(String cpf) {
        return contaRepo.findByClienteCpf(cpf)
                .map(Conta::getNumeroConta)
                .orElse(null);
    }

    public SaldoRespostaDTO consultarSaldoPorCpf(String cpf) {
        Conta conta = contaRepo.findByClienteCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Conta não encontrada para CPF: " + cpf));
        String nome = conta.getCliente().getUsuario().getNome();
        BigDecimal saldo = conta.getSaldo();

        return new SaldoRespostaDTO(nome, saldo);
    }
}