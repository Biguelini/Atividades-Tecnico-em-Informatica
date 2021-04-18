/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import bd.BdDependente;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import vo.Dependentes;
@ManagedBean
@SessionScoped
/**
 *
 * @author JP
 */
public class DependenteBean {

    private Dependentes dependente;
    private final BdDependente bda = new BdDependente();
    private DataModel<Dependentes> lista;

    public DependenteBean() {
        atualizaLista();
    }

    /**
     * @return the dependente
     */
    public Dependentes getDependente() {
        return dependente;
    }

    /**
     * @param dependente the dependente to set
     */
    public void setDependente(Dependentes dependente) {
        this.dependente = dependente;
    }

    /**
     * @return the lista
     */
    public DataModel<Dependentes> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(DataModel<Dependentes> lista) {
        this.lista = lista;
    }

    public String salva() {
        bda.salva(dependente);
        atualizaLista();
        return "dependentes";
    }

    public final void atualizaLista() {
        lista = new ListDataModel(bda.pesquisa(""));
    }

    public String exclui() {
        dependente = lista.getRowData();
        bda.exclui(dependente.getId());
        atualizaLista();
        return "";
    }

    public String novo() {
        dependente = new Dependentes();
        return "cadastro_dependente";
    }

    public String edita() {
        dependente = lista.getRowData();
        return "cadastro_dependente";
    }
}
