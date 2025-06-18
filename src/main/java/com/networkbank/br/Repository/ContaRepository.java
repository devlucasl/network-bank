package com.networkbank.br.Repository;


import com.networkbank.br.Entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ContaRepository extends JpaRepository<Conta, Long> {
    @Query("SELECT c FROM Conta c WHERE c.cliente.usuario.cpf = :cpf")
    Optional<Conta> findByClienteCpf(@Param("cpf") String cpf);

    Optional<Conta> findByNumeroConta(String numeroConta);
}