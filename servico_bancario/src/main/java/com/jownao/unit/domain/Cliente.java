package com.jownao.unit.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;


@Entity
@Data
public class Cliente { //POJO --> Domain Entity
    
    @Id @GeneratedValue private long id;
    private Integer numeroConta;
    private String nome;
    private double saldoConta;

    public Cliente() {
    }


    public Cliente(long id, Integer numeroConta, String nome, double saldoConta) {
        this.id = id;
        this.numeroConta = numeroConta;
        this.nome = nome;
        this.saldoConta = saldoConta;
    }
   
    

    public void saque(double valor){
        this.saldoConta -= valor;
    }
    public void deposito(double valor){
        this.saldoConta += valor;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", numeroConta='" + getNumeroConta() + "'" +
            ", nome='" + getNome() + "'" +
            ", saldoConta='" + getSaldoConta() + "'" +
            "}";
    }


}

    
