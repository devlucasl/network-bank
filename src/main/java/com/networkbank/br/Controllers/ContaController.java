package com.networkbank.br.Controllers;

import com.networkbank.br.SaldoRespostaDTO;
import com.networkbank.br.Service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @PostMapping("/depositar")
    public ResponseEntity<String> depositar(@RequestParam String cpf,
                                            @RequestParam BigDecimal valor) {
        try {
            contaService.depositarPorCpf(cpf, valor);
            return ResponseEntity.ok("Depósito realizado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao realizar depósito: " + e.getMessage());
        }
    }

    @GetMapping("/saldo")
    public ResponseEntity<SaldoRespostaDTO> saldoPorCpf(@RequestParam String cpf) {
        try {
            SaldoRespostaDTO resposta = contaService.consultarSaldoPorCpf(cpf); // ← Está correto!
            return ResponseEntity.ok(resposta);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}

