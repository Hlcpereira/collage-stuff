/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hlcpereira.ifc.av2.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.ArrayList;

import com.hlcpereira.ifc.av2.model.Tecnico;

/**
 *
 * @author henrique
 */
public class TecnicoDao {
    private Tecnico tecnico;
    private ArrayList<Tecnico> tecnicos = new ArrayList();

    public ArrayList<Tecnico> retornarTecnicos() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
        EntityManager em = emf.createEntityManager();
        tecnicos = (ArrayList<Tecnico>) em.createQuery("from Tecnico", Tecnico.class)
            .getResultList();
        return tecnicos;
    }
    
    public boolean incluirTecnico(Tecnico nova) {
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
    
    public Tecnico buscarTecnico(Long id) {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
            EntityManager em = emf.createEntityManager();
            tecnico = em.createQuery("from Tecnico where id = :id", Tecnico.class)
                .setParameter("id", id)
                .getSingleResult();
            return tecnico;
        } catch (Exception e) {
            System.out.println("depuração: " + e.getMessage());
            return null;
        }
    }
    
    public boolean atualizarTecnico(Tecnico novosDados) {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
            EntityManager em = emf.createEntityManager();
            tecnico = em.createQuery("from Tecnico where id = :id", Tecnico.class)
                .setParameter("id", novosDados.getId())
                .getSingleResult();
            
            Tecnico atualizado = (Tecnico) em.createQuery("update Tecnico t set t.nome= :nome where s.id= :id", Tecnico.class)
                .setParameter("nome", novosDados.getNome())
                .setParameter("id", novosDados.getId());
            
            return true;
        } catch (Exception e) {
            System.out.println("depuração: " + e.getMessage());
            return false;
        }
    }
}
