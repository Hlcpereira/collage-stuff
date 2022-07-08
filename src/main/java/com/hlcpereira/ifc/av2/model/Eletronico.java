/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hlcpereira.ifc.av2.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "pgm4_henrique_pereira_eletronico") 
public abstract class Eletronico {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="pgm4_henrique_pereira_eletronico_seq")
    @SequenceGenerator(name = "pgm4_henrique_pereira_eletronico_seq", initialValue = 1)
    protected Integer id;
    protected String marca;
    protected String voltagen;
    protected String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getVoltagen() {
        return voltagen;
    }

    public void setVoltagen(String voltagen) {
        this.voltagen = voltagen;
    }

    public String getType() {
        return type;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eletronico")
    public void setType(String type) {
        this.type = type;
    }
    
    @Override
    public String toString() {
	return "Eletrônico [marca = " + marca + ", voltagen = " + voltagen + ", tipo = " + type + "]";
    }
}
