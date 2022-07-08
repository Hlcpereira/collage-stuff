/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hlcpereira.ifc.av2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.Table;

/**
 *
 * @author henrique
 */
@Entity
@Inheritance
@Table(name = "cpu")
public class Cpu extends Eletronico {
    @Override
    public String toString() {
	return "Cpu [marca = " + marca + ", voltagen = " + voltagen + ", tipo = " + type + "]";
    }
}
