package com.jownao.app;
import java.math.BigInteger;

import com.jownao.domain.Cliente;
import com.jownao.domain.Produto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
    
    @PostMapping("v1/cliente")
    public ResponseEntity<Cliente> enviarCliente(@RequestBody Cliente cliente){
        try {
            System.out.println("O cliente enviado foi: "+cliente.toString());
            return ResponseEntity.ok(cliente);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @PostMapping("v1/produto")
    public ResponseEntity<Produto> enviarProduto(@RequestBody Produto produto){
        try {
            System.out.println("O Produto enviado foi: "+produto.toString());
            return ResponseEntity.ok(produto);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("v1/cliente/{id}")
    public ResponseEntity<String> imprimirIdCliente(@PathVariable("id") long id){
        try {
            System.out.println("O id do cliente enviado foi: "+id);
            return ResponseEntity.ok("O id do cliente enviado foi: "+id);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Erro ao enviar o id: "+id);
        }
    }

    @GetMapping("v1/produto/{id}")
    public ResponseEntity<String> imprimirIdProduto(@PathVariable("id") long id){
        try {
            System.out.println("O id do produto enviado foi: "+id);
            return ResponseEntity.ok("O id do produto enviado foi: "+id);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Erro ao enviar o id: "+id);
        }
    }
    
    @GetMapping("v1/validacao")
    public ResponseEntity<Object> validarDado(@RequestHeader("password") BigInteger password,
    @RequestHeader("user") String user){
        BigInteger valor = new BigInteger("123456");
        if(password.compareTo(valor) == 0){
            return ResponseEntity.accepted().body(user);
        }else{
            return ResponseEntity.badRequest().body(false);
        }  
    }

}
