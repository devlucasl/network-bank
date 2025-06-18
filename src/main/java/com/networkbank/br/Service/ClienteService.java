package com.networkbank.br.Service;

import com.networkbank.br.Entity.Cliente;
import com.networkbank.br.Entity.Conta;
import com.networkbank.br.Enums.StatusConta;
import com.networkbank.br.Enums.TipoConta;
import com.networkbank.br.Repository.ClienteRepository;
import com.networkbank.br.Repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepo;

    @Autowired
    private ContaRepository contaRepo;

    public Cliente salvar(Cliente cliente) {
        // Salva o cliente (com o usuário já preenchido)
        Cliente clienteSalvo = clienteRepo.save(cliente);

        // Verifica se já existe uma conta para este cliente
        boolean contaExiste = contaRepo.findByClienteCpf(clienteSalvo.getUsuario().getCpf()).isPresent();
        if (!contaExiste) {
            // Cria a conta
            Conta novaConta = new Conta();
            novaConta.setCliente(clienteSalvo);
            novaConta.setNumeroConta(gerarNumeroConta(clienteSalvo));
            novaConta.setSaldo(BigDecimal.ZERO);
            novaConta.setTipoConta(TipoConta.CORRENTE);
            novaConta.setDataAbertura(LocalDateTime.now());
            novaConta.setStatus(StatusConta.ATIVA);
            contaRepo.save(novaConta);
        }

        return clienteSalvo;
    }

    private String gerarNumeroConta(Cliente cliente) {
        return "000" + System.currentTimeMillis(); // ou outra estratégia
    }
}