/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import bd.BdDisciplina;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import vo.Disciplinas;

/**
 *
 * @author JP
 */
@ManagedBean
@SessionScoped
public class DisciplinasBean {
    private Disciplinas disciplina;
    private final BdDisciplina bda = new BdDisciplina();
    private DataModel<Disciplinas> lista;

    /**
     * @return the disciplina
     */
    public Disciplinas getDisciplina() {
        return disciplina;
    }

    /**
     * @param disciplina the disciplina to set
     */
    public void setDisciplina(Disciplinas disciplina) {
        this.disciplina = disciplina;
    }

    /**
     * @return the lista
     */
    public DataModel<Disciplinas> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(DataModel<Disciplinas> lista) {
        this.lista = lista;
    }
    public DisciplinasBean(){
        atualizaLista();
    }
    public String salva() {
        bda.salva(disciplina);
        atualizaLista();
        return "index";
    }

    public final void atualizaLista() {
        lista = new ListDataModel(bda.pesquisa(""));
    }

    public String exclui() {
        disciplina = lista.getRowData();
        bda.exclui(disciplina.getCodigo());
        atualizaLista();
        return "";
    }

    public String novo() {
        disciplina = new Disciplinas();
        return "disciplina";
    }

    public String edita() {
        disciplina = lista.getRowData();
        return "disciplina";
    }
}
