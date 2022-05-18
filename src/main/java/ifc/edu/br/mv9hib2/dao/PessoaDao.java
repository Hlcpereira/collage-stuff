/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifc.edu.br.mv9hib2.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.ArrayList;

import ifc.edu.br.mv9hib2.model.Pessoa;

/**
 *
 * @author henrique
 */
public class PessoaDao {
    private ArrayList<Pessoa> pessoas = new ArrayList();

    public ArrayList<Pessoa> retornarPessoas() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
        EntityManager em = emf.createEntityManager();
        pessoas = (ArrayList<Pessoa>) em.createQuery("from Pessoa", Pessoa.class)
            .getResultList();
        return pessoas;
    }
    
    public boolean incluirPessoa(Pessoa nova) {
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
    
    public Pessoa buscarPessoa(Long id) {
        try {
            for (int i = 0; i < pessoas.size(); i++) { // percorrer a lista 
                if (pessoas.get(i).getId().equals(id)) { // achou?
                    return pessoas.get(i);
                }
            }
            return null;
        } catch (Exception e) {
            System.out.println("depuração: " + e.getMessage());
            return null;
        }
    }
    
    public boolean atualizarPessoa(Pessoa novosDados) {
        try {
            int encontrado = -1; // variável para sinalizar sucesso da busca
            for (int i = 0; i < pessoas.size(); i++) { // percorrer a lista 
                if (pessoas.get(i).getId().equals(novosDados.getId())) { // achou?
                    encontrado = i; // sinaliza a posição da pessoa encontrada
                    break; // interrompe a busca
                }
            }
            if (encontrado >= 0) { // se achou...
                pessoas.set(encontrado, novosDados); // atualiza a pessoa
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("depuração: " + e.getMessage());
            return false;
        }
    }
}
