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
import persistencia.ProdutoDAO;
import vo.Produto;

@ManagedBean
@RequestScoped
public class TelaLocalizaBean implements Serializable {

    private DataModel<Produto> lista;
    ProdutoDAO pd = new ProdutoDAO();
    private Produto Produto = new Produto();

    public TelaLocalizaBean() {
    }

    public String atualizaLista() {
        lista = new ListDataModel(pd.pesquisa());
        return "index";
    }

    public DataModel<Produto> getLista() {
        atualizaLista();
        return lista;
    }

    public Produto ProdutoSelecionado() {
        Produto p = lista.getRowData();
        return p;
    }

    public String excluir() {
        Produto p = ProdutoSelecionado();
        pd.exclui(p);
        return "index";
    }

    public String novo() {
        setProduto(new Produto());
        return "produto";
    }

    public String editar() {
        Produto p = ProdutoSelecionado();
        setProduto(p);
        return "produto";
    }

    public String salva() {
        pd.salva(getProduto());
        return "index";
    }

    public String cancela() {
        return "index";
    }

    /**
     * @return the Produto
     */
    public Produto getProduto() {
        return Produto;
    }

    /**
     * @param Produto the Produto to set
     */
    public void setProduto(Produto Produto) {
        this.Produto = Produto;
    }
}
