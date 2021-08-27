/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package percistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import vo.Cliente;

/**
 *
 * @author 2info2021
 */
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

    public Cliente localiza(int id) {
        Cliente c = em.find(Cliente.class, id);
        return c;
    }

    public void exclui(Cliente c) {
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
    }

    public List<Cliente> pesquisa() {
        Query q = em.createQuery("select c from Cliente c order by c.nome");
        List<Cliente> listaCliente = q.getResultList();
        return listaCliente;
    }

    public List<Cliente> pesquisa(String nome) {
        Query q = em.createNativeQuery("select * from Cliente where nome like :nome order by nome", Cliente.class);
        q.setParameter("nome", '%' + nome + '%');
        List<Cliente> listaCliente = q.getResultList();
        return listaCliente;
    }
}
