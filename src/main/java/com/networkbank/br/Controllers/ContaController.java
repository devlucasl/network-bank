package com.networkbank.br.Controllers;

import com.networkbank.br.Service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/contas")
public class ContaController {
    @Autowired
    private ContaService contaService;

    @PostMapping("/depositar")
    public ResponseEntity<String> depositar(@RequestParam String numeroConta,
                                            @RequestParam BigDecimal valor) {
        contaService.depositar(numeroConta, valor);
        return ResponseEntity.ok("Depósito realizado com sucesso");
    }

    @GetMapping("/{numeroConta}/saldo")
    public ResponseEntity<BigDecimal> saldo(@PathVariable String numeroConta) {
        return ResponseEntity.ok(contaService.consultarSaldo(numeroConta));
    }
}

