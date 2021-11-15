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
import vo.Responsavel;
public class ResponsavelDAO {

    EntityManager em;

    public ResponsavelDAO() {
        em = EntityManagerProvider.getEM();
    }

    public void salva(Responsavel r) {
        em.getTransaction().begin();
        if (r.getCodigo() == 0) {
            em.persist(r);
        } else {
            em.merge(r);
        }
        em.getTransaction().commit();
    }

    public Responsavel localiza(int codigo) {
        Responsavel r = em.find(Responsavel.class, codigo);
        return r;
    }

    public void exclui(Responsavel r) {
        em.getTransaction().begin();
        em.remove(r);
        em.getTransaction().commit();
    }

    public List<Responsavel> pesquisa() {
        Query q = em.createQuery("select r from Responsavel r order by r.nome");
        List<Responsavel> lista = q.getResultList();
        return lista;
    }

    public List<Responsavel> pesquisa(String nome) {
        Query q = em.createNativeQuery("select * from responsavel where nome like :nome order by nome", Responsavel.class);
        q.setParameter("nome", '%' + nome + '%');
        List<Responsavel> lista = q.getResultList();
        return lista;
    }
}
