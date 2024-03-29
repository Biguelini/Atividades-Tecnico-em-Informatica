/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import vo.Produto;

/**
 *
 * @author 2info2021
 */
public class ProdutoDAO {
    EntityManager em;

    public ProdutoDAO() {
        em = EntityManagerProvider.getEM();
    }

    public void salva(Produto p) {
        em.getTransaction().begin();
        if (p.getId() == 0) {
            em.persist(p);
        } else {
            em.merge(p);
        }
        em.getTransaction().commit();
    }

    public Produto localiza(int id) {
        Produto p = em.find(Produto.class, id);
        return p;
    }

    public void exclui(Produto p) {
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
    }

    public List<Produto> pesquisa() {
        Query q = em.createQuery("select p from Produto p order by p.descricao");
        List<Produto> listaProduto = q.getResultList();
        return listaProduto;
    }

    public List<Produto> pesquisa(String descricao) {
        Query q = em.createNativeQuery("select * from produto where descricao like :descricao order by descricao", Produto.class);
        q.setParameter("descricao", '%' + descricao + '%');
        List<Produto> listaProduto = q.getResultList();
        return listaProduto;
    }
}
