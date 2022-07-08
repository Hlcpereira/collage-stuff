/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hlcpereira.ifc.av2.dao;

import com.hlcpereira.ifc.av2.model.Manutencao;
import com.hlcpereira.ifc.av2.model.Tecnico;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.ArrayList;

/**
 *
 * @author henrique
 */
public class ManutencaoDao {
    private ArrayList<Manutencao> manutencoes = new ArrayList();
    private Manutencao manutencao;
    
    public ArrayList<Manutencao> retornarManutencoes() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
        EntityManager em = emf.createEntityManager();
        manutencoes = (ArrayList<Manutencao>) em.createQuery("from Manutencao", Manutencao.class)
            .getResultList();
        return manutencoes;
    }
    
    public boolean incluirManutencao(Manutencao nova) {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
            EntityManager em = emf.createEntityManager();

            EntityTransaction tx = em.getTransaction();

            tx.begin();
            em.persist(nova);
            tx.commit();
            em.close();
  
            return true;
        } catch (Exception e) {
            System.out.println("depuração: " + e.getMessage());
            return false;
        }
    }
    
    public Manutencao buscarManutencao(Long id) {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
            EntityManager em = emf.createEntityManager();
            manutencao = em.createQuery("from Manutencao where id = :id", Manutencao.class)
                .setParameter("id", id)
                .getSingleResult();
            return manutencao;
        } catch (Exception e) {
            System.out.println("depuração: " + e.getMessage());
            return null;
        }
    }
}
