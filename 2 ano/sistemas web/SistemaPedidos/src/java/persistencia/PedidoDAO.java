/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import vo.Pedido;

/**
 *
 * @author 2info2021
 */
public class PedidoDAO {
    EntityManager em;

    public PedidoDAO() {
        em = EntityManagerProvider.getEM();
    }

    public void salva(Pedido p) {
        em.getTransaction().begin();
        if (p.getId() == 0) {
            em.persist(p);
        } else {
            em.merge(p);
        }
        em.getTransaction().commit();
    }

    public Pedido localiza(int id) {
        Pedido p = em.find(Pedido.class, id);
        return p;
    }


    public List<Pedido> pesquisa() {
        Query q = em.createQuery("select p from Pedido p order by p.id");
        List<Pedido> listaPedido = q.getResultList();
        return listaPedido;
    }

}
