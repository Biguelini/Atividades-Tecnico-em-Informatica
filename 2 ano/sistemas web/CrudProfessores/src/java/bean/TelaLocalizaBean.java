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
import persistencia.ProfessorDAO;
import vo.Professor;

@ManagedBean
@RequestScoped
public class TelaLocalizaBean implements Serializable {

    private DataModel<Professor> lista;
    ProfessorDAO pd = new ProfessorDAO();
    private Professor professor = new Professor();

    public TelaLocalizaBean() {
    }

    public String atualizaLista() {
        lista = new ListDataModel(pd.pesquisa());
        return "index";
    }

    public DataModel<Professor> getLista() {
        atualizaLista();
        return lista;
    }

    public Professor professorSelecionado() {
        Professor p = lista.getRowData();
        return p;
    }

    public String excluir() {
        Professor p = professorSelecionado();
        pd.exclui(p);
        return "index";
    }

    public String novo() {
        setProfessor(new Professor());
        return "professor";
    }

    public String editar() {
        Professor p = professorSelecionado();
        setProfessor(p);
        return "professor";
    }

    public String salva() {
        pd.salva(getProfessor());
        return "index";
    }

    public String cancela() {
        return "index";
    }

    /**
     * @return the professor
     */
    public Professor getProfessor() {
        return professor;
    }

    /**
     * @param professor the professor to set
     */
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
