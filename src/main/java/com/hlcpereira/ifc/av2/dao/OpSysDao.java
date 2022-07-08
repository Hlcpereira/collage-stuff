/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hlcpereira.ifc.av2.dao;

import com.hlcpereira.ifc.av2.model.OpSys;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author henrique
 */
public class OpSysDao {
    private OpSys opSys;

    public OpSys buscarOpSys(Long id) {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
            EntityManager em = emf.createEntityManager();
            opSys = em.createQuery("from OpSys where id = :id", OpSys.class)
                .setParameter("id", id)
                .getSingleResult();
            return opSys;
        } catch (Exception e) {
            System.out.println("depuração: " + e.getMessage());
            return null;
        }
    }
}
