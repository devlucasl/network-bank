package com.networkbank.br.Entity;

import com.networkbank.br.Enums.StatusConta;
import com.networkbank.br.Enums.TipoConta;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Getter
@Setter
@Table(name = "conta")
public class Conta {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idConta;
    private String numeroConta;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    private BigDecimal saldo;
    @Enumerated(EnumType.STRING)
    private TipoConta tipoConta;
    private LocalDateTime dataAbertura;
    @Enumerated(EnumType.STRING)
    private StatusConta status;
}