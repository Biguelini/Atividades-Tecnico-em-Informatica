/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author JP
 */
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;

import javax.faces.model.ListDataModel;
import persistencia.AlunoDAO;
import persistencia.ResponsavelDAO;
import vo.Aluno;
import vo.Responsavel;

@ManagedBean
@RequestScoped
public class TelaLocalizaBean implements Serializable {

    private DataModel<Responsavel> lista;
    private DataModel<Aluno> listaAluno;
    ResponsavelDAO rd = new ResponsavelDAO();
    AlunoDAO ad = new AlunoDAO();
    private Responsavel responsavel = new Responsavel();
    private Aluno aluno = new Aluno();
    
    public TelaLocalizaBean() {
    }

    public String atualizaLista() {
        lista = new ListDataModel(rd.pesquisa());
        return "index";
    }
    public String atualizaListaAluno() {
        listaAluno = new ListDataModel(ad.pesquisa());
        return "listaAlunos";
    }

    public DataModel<Responsavel> getLista() {
        atualizaLista();
        return lista;
    }
    public DataModel<Aluno> getListaAluno() {
        atualizaListaAluno();
        return listaAluno;
    }

    public Responsavel responsavelSelecionado() {
        Responsavel r = lista.getRowData();
        return r;
    }
    public Aluno alunoSelecionado() {
        Aluno a = listaAluno.getRowData();
        return a;
    }

    public String excluir() {
        Responsavel r = responsavelSelecionado();
        if(ad.pesquisaDependentes(r.getCodigo()).size() <= 0){
            rd.exclui(r);
        }
        System.out.println(ad.pesquisaDependentes(r.getCodigo()).size());
        return "index";
    }
    public String excluirAluno() {
        Aluno a = alunoSelecionado();
        ad.exclui(a);
        return "listaAlunos";
    }

    public String novo() {
        setResponsavel(new Responsavel());
        return "responsavel";
    }
    public String novoAluno() {
        Responsavel r = responsavelSelecionado();
        setAluno(new Aluno());
        aluno.setIdResponsavel(r.getCodigo());
        return "aluno";
    }

    public String editar() {
        Responsavel r = responsavelSelecionado();
        setResponsavel(r);
        return "responsavel";
    }
    public String editarAluno() {
        Aluno a = alunoSelecionado();
        setAluno(a);
        return "aluno";
    }

    public String salva() {
        rd.salva(getResponsavel());
        return "index";
    }
    public String salvaAluno() {
        ad.salva(getAluno());
        return "listaAlunos";
    }

    public String cancela() {
        return "index";
    }
    public String cancelaAluno() {
        return "listaAlunos";
    }

    /**
     * @return the responsavel
     */
    public Responsavel getResponsavel() {
        return responsavel;
    }

    /**
     * @param responsavel the responsavel to set
     */
    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }

    /**
     * @return the aluno
     */
    public Aluno getAluno() {
        return aluno;
    }

    /**
     * @param aluno the aluno to set
     */
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}
