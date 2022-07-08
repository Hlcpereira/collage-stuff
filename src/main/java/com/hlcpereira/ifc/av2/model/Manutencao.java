/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hlcpereira.ifc.av2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

/**
 *
 * @author henrique
 */
@Entity
@Table(name = "pgm4_henrique_pereira_manutencao") 
public class Manutencao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="pgm4_henrique_pereira_manutencao_seq")
    @SequenceGenerator(name = "pgm4_henrique_pereira_manutencao_seq", initialValue = 1)
    private Long id;
    @ManyToOne
    @JoinColumn(name="eletronico_id", nullable=false)
    private Eletronico eletronico;
    @ManyToOne
    @JoinColumn(name="op_sys_id", nullable=false)
    private OpSys opSys;
    @ManyToOne
    @JoinColumn(name="tecnico_id", nullable=false)
    private Tecnico tecnico;
    
    public Long getId() {
        return id;
    }

    public Eletronico getEletronico() {
        return eletronico;
    }

    public void setEletronico(Eletronico eletronico) {
        this.eletronico = eletronico;
    }

    public OpSys getOpSys() {
        return opSys;
    }

    public void setOpSys(OpSys opSys) {
        this.opSys = opSys;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }    
}
