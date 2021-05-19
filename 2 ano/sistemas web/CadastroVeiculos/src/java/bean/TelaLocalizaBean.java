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
import persistencia.VeiculosDAO;
import vo.Veiculos;

@ManagedBean
@RequestScoped
public class TelaLocalizaBean {

    private DataModel<Veiculos> lista;
    VeiculosDAO pd = new VeiculosDAO();
    private Veiculos veiculo = new Veiculos();

    public TelaLocalizaBean() {
    }

    public String atualizaLista() {
        lista = new ListDataModel(pd.pesquisa());
        return "index";
    }

    public DataModel<Veiculos> getLista() {
        atualizaLista();
        return lista;
    }

    public Veiculos VeiculosSelecionado() {
        Veiculos p = lista.getRowData();
        return p;
    }

    public String excluir() {
        Veiculos p = VeiculosSelecionado();
        pd.exclui(p);
        return "index";
    }

    public String novo() {
        veiculo = new Veiculos();
        return "Veiculos";
    }

    public String editar() {
        Veiculos p = VeiculosSelecionado();
        veiculo = p;
        return "Veiculos";
    }

    public String salva() {
        pd.salva(veiculo);
        return "index";
    }

    public String cancela() {
        return "index";
    }
}
