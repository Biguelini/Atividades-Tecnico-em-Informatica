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
import vo.Filme;

public class FilmeDAO {

    EntityManager em;

    public FilmeDAO() {
        em = EntityManagerProvider.getEM();
    }

    public void salva(Filme f) {
        em.getTransaction().begin();
        if (f.getId() == 0) {
            em.persist(f);
        } else {
            em.merge(f);
        }
        em.getTransaction().commit();
    }

    public Filme localiza(int id) {
        Filme f = em.find(Filme.class, id);
        return f;
    }

    public void exclui(Filme f) {
        em.getTransaction().begin();
        em.remove(f);
        em.getTransaction().commit();
    }

    public List<Filme> pesquisa() {
        Query q = em.createQuery("select f from Filme f order by f.titulo");
        List<Filme> lista = q.getResultList();
        return lista;
    }

    public List<Filme> pesquisa(String filme) {
        Query q = em.createNativeQuery("select * from filme where titulo like :titulo order by titulo", Filme.class);
        q.setParameter("filme", '%' + filme + '%');
        List<Filme> lista = q.getResultList();
        return lista;
    }
}
