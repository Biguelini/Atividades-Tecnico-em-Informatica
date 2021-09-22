/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author 2info2021
 */
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;

import javax.faces.model.ListDataModel;
import persistencia.CaixaDAO;
import vo.Caixa;

@ManagedBean
@RequestScoped
public class TelaLocalizaBean implements Serializable {

    private DataModel<Caixa> lista;
    CaixaDAO cd = new CaixaDAO();
    private Caixa caixa = new Caixa();

    public TelaLocalizaBean() {
    }

    public String atualizaLista() {
        lista = new ListDataModel(cd.pesquisa());
        return "index";
    }

    public DataModel<Caixa> getLista() {
        atualizaLista();
        return lista;
    }

    public Caixa caixaSelecionado() {
        Caixa c = lista.getRowData();
        return c;
    }

    public String excluir() {
        Caixa c = caixaSelecionado();
        cd.exclui(c);
        return "index";
    }

    public String novo() {
        setCaixa(new Caixa());
        return "caixa";
    }

    public String editar() {
        Caixa c = caixaSelecionado();
        setCaixa(c);
        return "caixa";
    }

    public String salva() {
        cd.salva(getCaixa());
        return "index";
    }

    public String cancela() {
        return "index";
    }

    /**
     * @return the caixa
     */
    public Caixa getCaixa() {
        return caixa;
    }

    /**
     * @param caixa the caixa to set
     */
    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }
}
