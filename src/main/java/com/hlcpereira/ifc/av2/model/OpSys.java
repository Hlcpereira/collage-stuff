/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hlcpereira.ifc.av2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

/**
 *
 * @author henrique
 */
@Entity
@Inheritance
@Table(name = "pgm4_henrique_pereira_op_sys") 
public class OpSys {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="pgm4_henrique_pereira_op_sys_seq")
    @SequenceGenerator(name = "pgm4_henrique_pereira_op_sys_seq", initialValue = 1)
    protected Integer id;
    protected String versao;
    protected String fornecedora;
    protected String type;

    public Integer getId() {
        return id;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public String getFornecedora() {
        return fornecedora;
    }

    public void setFornecedora(String fornecedora) {
        this.fornecedora = fornecedora;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
