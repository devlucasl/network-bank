package com.networkbank.br.Repository;


import com.networkbank.br.Entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ContaRepository extends JpaRepository<Conta, Long> {
    Optional<Conta> findByClienteUsuarioCpf(String cpf);
}
