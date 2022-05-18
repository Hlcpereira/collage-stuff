/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifc.edu.br.mv9hib2.dao;

import ifc.edu.br.mv9hib2.model.Nacionalidade;
import java.util.ArrayList;

/**
 *
 * @author henrique
 */
public class NacionalidadeDao {
    private ArrayList<Nacionalidade> nacionalidades = new ArrayList();
    
    public Nacionalidade buscarNacionalidade(Long id) {
        try {
            for (int i = 0; i < nacionalidades.size(); i++) { // percorrer a lista 
                if (nacionalidades.get(i).getId().equals(id)) { // achou?
                    return nacionalidades.get(i);
                }
            }
            return null;
        } catch (Exception e) {
            System.out.println("depuração: " + e.getMessage());
            return null;
        }
    }
}
