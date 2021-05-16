package com.jownao.domain;

import java.time.LocalDate;

public class Cliente { //POJO --> Domain Entity
    
    private long id;
    private String nome;
    private String endereco;
    private LocalDate  dataCadastro;


    public Cliente() {
    }

    public Cliente(long id, String nome, String endereco) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.setDataCadastro(LocalDate.now());
    }


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

    

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nome='" + getNome() + "'" +
            ", endereco='" + getEndereco() + "'" +
            ", dataCadastro='" + getDataCadastro() + "'" +
            "}";
    }

}

    
