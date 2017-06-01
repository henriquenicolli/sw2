/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.DAO;

import br.com.modelo.Produtos;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Andressa
 */
public class ProdutosDAO {

    public void persist(Produtos produto) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabalho");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(produto);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    
}
