package br.com.DAO;

import br.com.modelo.Produto;
import br.com.util.JPAUtil;
import javax.persistence.EntityManager;

public class ProdutoDAO  {

    public void salvar(Produto produto) {
        
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        em.merge(produto);
        em.getTransaction().commit();
        em.close();

    }
}
