/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hlcpereira.ifc.av2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(
    name = "pgm4_henrique_pereira_tecnico",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"cpf"})}
) 
public class Tecnico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="pgm4_henrique_pereira_tecnico_seq")
    @SequenceGenerator(name = "pgm4_henrique_pereira_tecnico_seq", initialValue = 1)
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;

    public Tecnico() {
    }

    /*public Tecnico(String nome, String email, Float peso, Nacionalidade nacionalidade) {
        this.nome = nome;
        this.email = email;
        this.peso = peso;
        this.nacionalidade = nacionalidade;
    }*/

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    
    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
