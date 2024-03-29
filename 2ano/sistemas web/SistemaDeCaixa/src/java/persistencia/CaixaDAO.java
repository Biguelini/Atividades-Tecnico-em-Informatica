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
import vo.Caixa;

public class CaixaDAO {

    EntityManager em;

    public CaixaDAO() {
        em = EntityManagerProvider.getEM();
    }

    public void salva(Caixa c) {
        em.getTransaction().begin();
        if (c.getId() == 0) {
            em.persist(c);
        } else {
            em.merge(c);
        }
        em.getTransaction().commit();
    }

    public Caixa localiza(int id) {
        Caixa c = em.find(Caixa.class, id);
        return c;
    }

    public List<Caixa> pesquisa() {
        Query q = em.createQuery("select c from Caixa c order by c.data DESC");
        List<Caixa> lista = q.getResultList();
        return lista;
    }
    public List<Caixa> pesquisaSaidas() {
        Query q = em.createQuery("select c from Caixa c where c.tipo = 'Saida' order by c.data DESC");
        List<Caixa> listaSaidas = q.getResultList();
        return listaSaidas;
    }
    public List<Caixa> pesquisaEntradas() {
        Query q = em.createQuery("select c from Caixa c where c.tipo = 'Entrada' order by c.data DESC");
        List<Caixa> listaEntradas = q.getResultList();
        return listaEntradas;
    }
    public Double calcularSaldo(){
        Double entradas = calcularSaldoEntradas();
        Double saidas = calcularSaldoSaidas();
        Double saldo = entradas - saidas;
        return saldo;
    }
    public Double calcularSaldoEntradas(){
        Query q = em.createNativeQuery("select SUM(valor) from caixa where tipo = 'Entrada'");
        List<Double> lista = q.getResultList();
        Double saldo = lista.get(0)!=null?lista.get(0):0;
        return saldo;
    }
    public Double calcularSaldoSaidas(){
        Query q = em.createNativeQuery("select SUM(valor) from caixa where tipo = 'Saida'");
        List<Double> lista = q.getResultList();
        Double saldo = lista.get(0)!=null?lista.get(0):0;
        return saldo;
    }
}
