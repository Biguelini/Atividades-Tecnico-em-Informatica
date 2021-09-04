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
import vo.Veiculo;

public class VeiculoDAO {

    EntityManager em;

    public VeiculoDAO() {
        em = EntityManagerProvider.getEM();
    }

    public void salva(Veiculo v) {
        em.getTransaction().begin();
        if (v.getId() == 0) {
            em.persist(v);
        } else {
            em.merge(v);
        }
        em.getTransaction().commit();
    }

    public Veiculo localiza(int codigo) {
        Veiculo v = em.find(Veiculo.class, codigo);
        return v;
    }

    public void exclui(Veiculo v) {
        em.getTransaction().begin();
        em.remove(v);
        em.getTransaction().commit();
    }

    public List<Veiculo> pesquisa() {
        Query q = em.createQuery("select v from Veiculo as v order by v.placa");
        List<Veiculo> lista = q.getResultList();
        return lista;
    }

    public List<Veiculo> pesquisa(String placa) {
        Query q = em.createNativeQuery("select * from veiculo where placa like ? order by placa ", Veiculo.class);
        q.setParameter(1, '%' + placa + '%');
        List<Veiculo> lista = q.getResultList();
        return lista;
    }
}
