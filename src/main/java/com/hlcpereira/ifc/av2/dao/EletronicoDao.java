/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hlcpereira.ifc.av2.dao;

import com.hlcpereira.ifc.av2.model.Eletronico;
import com.hlcpereira.ifc.av2.model.Tecnico;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.ArrayList;

/**
 *
 * @author henrique
 */
public class EletronicoDao {
    private Eletronico eletronico;
    private ArrayList<Eletronico> eletronicos = new ArrayList();

    public ArrayList<Eletronico> retornarEletronicos() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
        EntityManager em = emf.createEntityManager();
        eletronicos = (ArrayList<Eletronico>) em.createQuery("from Eletronico", Eletronico.class)
            .getResultList();
        return eletronicos;
    }

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
