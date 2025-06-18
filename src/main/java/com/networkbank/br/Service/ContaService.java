package com.networkbank.br.Service;

import com.networkbank.br.Entity.Conta;
import com.networkbank.br.Entity.Transacao;
import com.networkbank.br.Enums.TipoTransacao;
import com.networkbank.br.Repository.ContaRepository;
import com.networkbank.br.Repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class ContaService {
    @Autowired private ContaRepository contaRepo;
    @Autowired private TransacaoRepository transacaoRepo;

    public void depositar(String numeroConta, BigDecimal valor) {
        Conta conta = contaRepo.findByClienteUsuarioCpf(numeroConta)
                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));
        conta.setSaldo(conta.getSaldo().add(valor));

        Transacao t = new Transacao();
        t.setContaOrigem(conta);
        t.setTipoTransacao(TipoTransacao.DEPOSITO);
        t.setValor(valor);
        t.setDataHora(LocalDateTime.now());
        t.setDescricao("Depósito realizado");

        transacaoRepo.save(t);
        contaRepo.save(conta);
    }

    public BigDecimal consultarSaldo(String numeroConta) {
        return contaRepo.findByClienteUsuarioCpf(numeroConta)
                .map(Conta::getSaldo)
                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));
    }
}