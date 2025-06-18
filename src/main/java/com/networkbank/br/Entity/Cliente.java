package com.networkbank.br.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Data
@Getter
@Setter
@Table(name = "cliente")
public class Cliente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    private BigDecimal scoreCredito;
}