package br.com.testes;

import br.com.util.JPAUtil;
import br.com.modelo.Produto;
import javax.persistence.EntityManager;

public class ProdutoTeste {

    public static void main(String[] args) {
        
        Produto produto = new Produto();
        produto.setCodigoProduto(1244);
        produto.setCategoria("Esported");
        produto.setDescricao("Tenis para corridad");
        produto.setNome("Tenis Nike");

        EntityManager em = new JPAUtil().getEntityManager();

        em.getTransaction().begin();
        em.persist(produto);
        em.getTransaction().commit();

        em.close();
    }
}
