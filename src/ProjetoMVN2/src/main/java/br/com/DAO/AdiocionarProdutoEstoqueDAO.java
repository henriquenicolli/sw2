/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.DAO;

import br.com.modelo.AdicionarProdutoEstoque;
import br.com.util.JPAUtil;
import javax.persistence.EntityManager;
/**
 *
 * @author Lua
 */
public class AdiocionarProdutoEstoqueDAO {
    public void salvar(AdicionarProdutoEstoque adiocionarprodutoestoque) {
        
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        em.merge(adiocionarprodutoestoque);
        em.getTransaction().commit();
        em.close();

    }
}
