/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifc.edu.br.mv9hib2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "pgm4_henrique_pereira_pessoa") 
public class Pessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="pgm4_henrique_pereira_pessoa_seq")
    @SequenceGenerator(name = "pgm4_henrique_pereira_pessoa_seq", initialValue = 1)
    private Long id;
    private String nome;
    private String email;
    private Float peso;
    @ManyToOne
    @JoinColumn(name="nacionalidade_id", nullable=false)
    private Nacionalidade nacionalidade;

    public Pessoa(String nome, String email, Float peso, Nacionalidade nacionalidade) {
        this.nome = nome;
        this.email = email;
        this.peso = peso;
        this.nacionalidade = nacionalidade;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public Float getPeso() {
        return peso;
    }

    public Nacionalidade getNacionalidade() {
        return nacionalidade;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public void setNacionalidade(Nacionalidade nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
}
