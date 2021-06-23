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
import persistencia.FilmeDAO;
import vo.Filme;

@ManagedBean
@RequestScoped
public class TelaLocalizaBean implements Serializable {

    private DataModel<Filme> lista;
    FilmeDAO fd = new FilmeDAO();
    private Filme Filme = new Filme();

    public TelaLocalizaBean() {
    }

    public String atualizaLista() {
        lista = new ListDataModel(fd.pesquisa());
        return "listafilme";
    }

    public DataModel<Filme> getLista() {
        atualizaLista();
        return lista;
    }

    public Filme FilmeSelecionado() {
        Filme f = lista.getRowData();
        return f;
    }

    public String excluir() {
        Filme f = FilmeSelecionado();
        fd.exclui(f);
        return "listafilme";
    }

    public String novo() {
        setFilme(new Filme());
        return "cadastro";
    }

    public String editar() {
        Filme f = FilmeSelecionado();
        setFilme(f);
        return "cadastro";
    }

    public String salva() {
        fd.salva(getFilme());
        return "listafilme";
    }

    public String cancela() {
        return "listafilme";
    }

    /**
     * @return the Filme
     */
    public Filme getFilme() {
        return Filme;
    }

    /**
     * @param Filme the Filme to set
     */
    public void setFilme(Filme Filme) {
        this.Filme = Filme;
    }
}
