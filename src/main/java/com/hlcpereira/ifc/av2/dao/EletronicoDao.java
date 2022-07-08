/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hlcpereira.ifc.av2.dao;

import com.hlcpereira.ifc.av2.model.Eletronico;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author henrique
 */
public class EletronicoDao {
    private Eletronico eletronico;

    public Eletronico buscarEletronico(Long id) {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
            EntityManager em = emf.createEntityManager();
            eletronico = em.createQuery("from Eletronico where id = :id", Eletronico.class)
                .setParameter("id", id)
                .getSingleResult();
            return eletronico;
        } catch (Exception e) {
            System.out.println("depuração: " + e.getMessage());
            return null;
        }
    }
}
