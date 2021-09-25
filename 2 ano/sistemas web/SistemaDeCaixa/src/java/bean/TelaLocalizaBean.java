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
    private DataModel<Caixa> listaSaida;
    private DataModel<Caixa> listaEntrada;
    CaixaDAO cd = new CaixaDAO();
    private Caixa caixa = new Caixa();
    public Double saldo(){
        return cd.calcularSaldo();
    }
    public Double saldoEntradas(){
        return cd.calcularSaldoEntradas();
    }
    public Double saldoSaidas(){
        return cd.calcularSaldoSaidas();
    }

    public TelaLocalizaBean() {
    }

    public String atualizaLista() {
        lista = new ListDataModel(cd.pesquisa());
        return "index";
    }
    public String atualizaListaSaidas() {
        lista = new ListDataModel(cd.pesquisaSaidas());
        return "saidas";
    }
    public String atualizaListaEntradas() {
        lista = new ListDataModel(cd.pesquisaEntradas());
        return "entradas";
    }

    public DataModel<Caixa> getLista() {
        atualizaLista();
        return lista;
    }


    public Caixa caixaSelecionado() {
        Caixa c = lista.getRowData();
        return c;
    }


    public String novo() {
        setCaixa(new Caixa());
        return "cadastro.xhtml";
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

    /**
     * @return the listaSaida
     */
    public DataModel<Caixa> getListaSaida() {
        atualizaListaSaidas();
        return listaSaida;
    }

    /**
     * @return the listaEntrada
     */
    public DataModel<Caixa> getListaEntrada() {
        atualizaListaEntradas();
        return listaEntrada;
    }
}
