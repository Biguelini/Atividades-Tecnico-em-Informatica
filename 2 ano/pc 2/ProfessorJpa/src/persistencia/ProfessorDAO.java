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
import vo.Professor;

public class ProfessorDAO {

    EntityManager em;

    public ProfessorDAO() {
        em = EntityManagerProvider.getEM();
    }

    public void salva(Professor p) {
        em.getTransaction().begin();
        if (p.getCodigo() == 0) {
            em.persist(p);
        } else {
            em.merge(p);
        }
        em.getTransaction().commit();
    }

    public Professor localiza(int codigo) {
        Professor p = em.find(Professor.class, codigo);
        return p;
    }

    public void exclui(Professor p) {
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
    }

    public List<Professor> pesquisa() {
        Query q = em.createQuery("select p from Professor as p order by p.nome");
        List<Professor> lista = q.getResultList();
        return lista;
    }

    public List<Professor> pesquisa(String nome) {
        Query q = em.createNativeQuery("select * from professor where nome like ? order by nome", Professor.class);
        q.setParameter(1, '%' + nome + '%');
        List<Professor> lista = q.getResultList();
        return lista;
    }
}
