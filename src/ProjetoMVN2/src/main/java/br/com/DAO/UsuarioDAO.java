package br.com.DAO;

import br.com.modelo.Usuario;
import br.com.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;

public class UsuarioDAO {

    public void salvar(Usuario usuario) {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        em.merge(usuario);
        em.getTransaction().commit();
        em.close();
    }

    public void deletar(int id) {
        EntityManager manager = new JPAUtil().getEntityManager();
        Usuario usuario = this.get(id);
        manager.getTransaction().begin();
        manager.remove(manager.contains(usuario) ? usuario : manager.merge(usuario));
        manager.getTransaction().commit();
        manager.close();
    }

    public Usuario get(int id) {
        EntityManager manager = new JPAUtil().getEntityManager();
        Usuario u = manager.find(Usuario.class, id);
        manager.close();
        return u;

    }

    public List<Usuario> listar() {
        EntityManager manager = new JPAUtil().getEntityManager();
        List<Usuario> list = manager.createQuery("SELECT u FROM Usuario u").getResultList();
        manager.close();
        return list;

    }

    public boolean autenticar(String usuario, String senha) {
        EntityManager manager = new JPAUtil().getEntityManager();
        List<Usuario> list = manager.createQuery("SELECT u FROM Usuario u WHERE u.usuario = :usuario AND u.senha = :senha").
                setParameter("usuario", usuario)
                .setParameter("senha", senha)
                .getResultList();
        manager.close();
        return !list.isEmpty();
    }
}
