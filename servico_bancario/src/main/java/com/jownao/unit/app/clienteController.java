package com.jownao.unit.app;

import java.util.List;

import com.jownao.unit.domain.Cliente;
import com.jownao.unit.domain.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class clienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/v1")
    public String home(){
        return "Esta API é para implementar sistema bancário ";
    }


    @PostMapping("/v1/cliente")
    public ResponseEntity<Object> cadastroCliente(@RequestBody Cliente cliente){
        try {
            Cliente clienteAdd = clienteRepository.save(cliente);
            return ResponseEntity.ok(clienteAdd);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }
    //Serviço para realizar um depósito em uma determinada conta corrente
    @PutMapping("/v1/deposito/{numeroConta}")
    public ResponseEntity<Object> depositoConta(@PathVariable ("numeroConta") double numeroConta, @RequestBody double valor){
        try {
            Cliente cliente = clienteRepository.getOne(numeroConta);
            cliente.deposito(valor);
            Cliente clienteDeposito = clienteRepository.save(cliente);
            return ResponseEntity.ok(clienteDeposito);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }
    //Serviço para verificar o saldo dessa conta corrente
    @GetMapping("/v1/saldo/{numeroConta}")
    public ResponseEntity<Object> saldo (@PathVariable("numeroConta") String numeroConta){
        try {
            Double numeroContaA = Double.parseDouble(numeroConta);
            Cliente clienteSaldo = clienteRepository.getOne(numeroContaA);
            return ResponseEntity.ok(clienteSaldo.getSaldoConta());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }
    //Serviço para realizar um saque dessa conta corrente
    @PutMapping("/v1/saque/{numeroConta}")
    public ResponseEntity<Object> saque(@PathVariable("numeroConta") double numeroConta, @RequestBody double valor){
        try {
            Cliente cliente = clienteRepository.getOne(numeroConta);
            cliente.saque(valor);
            Cliente clienteSaque = clienteRepository.save(cliente);
            return ResponseEntity.ok(clienteSaque);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }
    /*
    @GetMapping("/v1/transacoes")
    public ResponseEntity<List<Cliente>> obterClientes(){
        try {
            List clientes = clienteRepository.findByStartDateBetween();
            if (clientes != null){
                return ResponseEntity.ok(clientes);
            }else{
                return ResponseEntity.badRequest().body(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }
    */
}

