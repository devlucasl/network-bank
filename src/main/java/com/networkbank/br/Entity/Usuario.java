package com.networkbank.br.Entity;

import com.networkbank.br.Enums.TipoUsuario;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Getter
@Setter
@Table(name = "usuario")
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer idUsuario;

    @Column(nullable = false)
    private String nome;
    @Column(unique = true, nullable = false, length = 11)
    private String cpf;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dataNascimento;
    private String telefone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoUsuario tipoUsuario;

    @Column(length = 32)
    private String senhaHash;

    @Column(length = 6)
    private String otpAtivo;

    private LocalDateTime otpExpiracao;
}
