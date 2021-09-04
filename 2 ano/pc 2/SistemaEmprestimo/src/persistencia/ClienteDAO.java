/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

/**
 *
 * @author JP
 */
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import vo.Cliente;
public class ClienteDAO {

    EntityManager em;

    public ClienteDAO() {
        em = EntityManagerProvider.getEM();
    }

    public void salva(Cliente c) {
        em.getTransaction().begin();
        if (c.getId() == 0) {
            em.persist(c);
        } else {
            em.merge(c);
        }
        em.getTransaction().commit();
    }

    public Cliente localiza(int codigo) {
        Cliente c = em.find(Cliente.class, codigo);
        return c;
    }

    public void exclui(Cliente c) {
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
    }

    public List<Cliente> pesquisa() {
        Query q = em.createQuery("select c from Cliente as c order by p.nome");
        List<Cliente> lista = q.getResultList();
        return lista;
    }

    public List<Cliente> pesquisa(String nome) {
        Query q = em.createNativeQuery("select * from cliente where nome like ? order by nome ", Cliente.class);
        q.setParameter(1, '%' + nome + '%');
        List<Cliente> lista = q.getResultList();
        return lista;
    }
}
