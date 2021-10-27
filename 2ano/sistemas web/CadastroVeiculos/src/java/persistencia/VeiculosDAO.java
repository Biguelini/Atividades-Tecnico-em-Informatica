/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

/**
 *
 * @author 2info2021
 */
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import vo.Veiculos;

public class VeiculosDAO {

    EntityManager em;

    public VeiculosDAO() {
        em = EntityManagerProvider.getEM();
    }

    public void salva(Veiculos v) {
        em.getTransaction().begin();
        if (v.getRenavam()=="") {
            em.persist(v);
        } else {
            em.merge(v);
        }
        em.getTransaction().commit();
    }

    public Veiculos localiza(int codigo) {
        Veiculos v = em.find(Veiculos.class, codigo);
        return v;
    }

    public void exclui(Veiculos v) {
        em.getTransaction().begin();
        em.remove(v);
        em.getTransaction().commit();
    }

    public List<Veiculos> pesquisa() {
        Query q = em.createQuery("select v from Veiculos v order by v.renavam");
        List<Veiculos> lista = q.getResultList();
        return lista;
    }

    public List<Veiculos> pesquisa(String renavam) {
        Query q = em.createNativeQuery("select * from veiculos where renavam like :renavam order by renavam", Veiculos.class);
        q.setParameter("renavam", '%' + renavam + '%');
        List<Veiculos> lista = q.getResultList();
        return lista;
    }
}
