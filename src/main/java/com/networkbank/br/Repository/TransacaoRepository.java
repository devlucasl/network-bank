package com.networkbank.br.Repository;

import com.networkbank.br.Entity.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {}
