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
import vo.Aluno;
public class AlunoDAO {
    EntityManager em;

    public AlunoDAO() {
        em = EntityManagerProvider.getEM();
    }

    public void salva(Aluno a) {
        em.getTransaction().begin();
        if (a.getCodigo() == 0) {
            em.persist(a);
        } else {
            em.merge(a);
        }
        em.getTransaction().commit();
    }

    public Aluno localiza(int codigo) {
        Aluno r = em.find(Aluno.class, codigo);
        return r;
    }

    public void exclui(Aluno a) {
        em.getTransaction().begin();
        em.remove(a);
        em.getTransaction().commit();
    }

    public List<Aluno> pesquisa() {
        Query q = em.createQuery("select a from Aluno a order by a.nome");
        List<Aluno> lista = q.getResultList();
        return lista;
    }

    public List<Aluno> pesquisa(String nome) {
        Query q = em.createNativeQuery("select * from aluno where nome like :nome order by nome", Aluno.class);
        q.setParameter("nome", '%' + nome + '%');
        List<Aluno> lista = q.getResultList();
        return lista;
    }
    public List<Aluno> pesquisaDependentes(Integer pesquisa) {
        Query q = em.createNativeQuery("select * from aluno where idResponsavel = :pesquisa", Aluno.class);
        q.setParameter("pesquisa", pesquisa);
        List<Aluno> lista = q.getResultList();
        return lista;
    }
}
