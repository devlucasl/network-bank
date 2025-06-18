package com.networkbank.br.Service;

import com.networkbank.br.Entity.Cliente;
import com.networkbank.br.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepo;

    public Cliente salvar(Cliente cliente) {
        return clienteRepo.save(cliente);
    }
}