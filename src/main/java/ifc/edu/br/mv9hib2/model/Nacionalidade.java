/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifc.edu.br.mv9hib2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.util.Set;

/**
 *
 * @author henrique
 */
@Entity
@Table(name = "pgm4_henrique_pereira_nacionalidade") 
public class Nacionalidade {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="pgm4_henrique_pereira_nacionalidade_seq")
    @SequenceGenerator(name = "pgm4_henrique_pereira_nacionalidade_seq", initialValue = 1)
    private Long id;
    private String nome;

    @OneToMany(mappedBy="nacionalidade")
    private Set<Pessoa> pessoas;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Set<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPessoas(Set<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
}
