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
import persistencia.ClienteDAO;
import persistencia.EmprestimoDAO;
import persistencia.FilmeDAO;
import vo.Cliente;
import vo.Emprestimo;
import vo.Filme;

@ManagedBean
@RequestScoped
public class TelaLocalizaBean implements Serializable {

    private DataModel<Filme> lista;
    FilmeDAO fd = new FilmeDAO();
    private Filme Filme = new Filme();
    private DataModel<Cliente> listacliente;
    ClienteDAO cd = new ClienteDAO();
    private Cliente Cliente = new Cliente();
    private DataModel<Emprestimo> emprestimos;
    EmprestimoDAO ed = new EmprestimoDAO();
    private Emprestimo Emprestimo = new Emprestimo();

    public TelaLocalizaBean() {
    }

    public String atualizaLista() {
        lista = new ListDataModel(fd.pesquisa());
        return "listafilmes";
    }
    public String atualizaListaCliente() {
        listacliente = new ListDataModel(cd.pesquisa());
        return "listaclientes";
    }
    public String atualizaListaEmprestimo(){
        emprestimos = new ListDataModel(cd.pesquisa());
        return "emprestimos";
    }

    public DataModel<Filme> getLista() {
        atualizaLista();
        return lista;
    }
    public DataModel<Cliente> getListaCliente() {
        atualizaListaCliente();
        return listacliente;
    }
    public DataModel<Emprestimo> getListaEmprestimo() {
        atualizaListaEmprestimo();
        return emprestimos;
    }

    public Filme FilmeSelecionado() {
        Filme f = lista.getRowData();
        return f;
    }
    public Cliente ClienteSelecionado() {
        Cliente c = listacliente.getRowData();
        return c;
    }
    public Emprestimo EmprestimoSelecionado() {
        Emprestimo e = emprestimos.getRowData();
        return e;
    }

    public String excluir() {
        Filme f = FilmeSelecionado();
        fd.exclui(f);
        return "listafilmes";
    }
    public String excluirCliente() {
        Cliente c = ClienteSelecionado();
        cd.exclui(c);
        return "listaclientes";
    }
    public String excluirEmprestimo() {
        Emprestimo e = EmprestimoSelecionado();
        ed.exclui(e);
        return "emprestimos";
    }

    public String novo() {
        setFilme(new Filme());
        return "cadastro";
    }
    public String novoCliente() {
        setCliente(new Cliente());
        return "cadastrocliente";
    }
    public String novoEmprestimo() {
        setEmprestimo(new Emprestimo());
        return "cadastroemprestimo";
    }

    public String editar() {
        Filme f = FilmeSelecionado();
        setFilme(f);
        return "cadastro";
    }
    public String editarCliente() {
        Cliente c = ClienteSelecionado();
        setCliente(c);
        return "cadastrocliente";
    }

    public String salva() {
        fd.salva(getFilme());
        return "listafilmes";
    }
    public String salvaCliente() {
        cd.salva(getCliente());
        return "listaclientes";
    }
    public String salvaEmprestimo() {
        ed.salva(getEmprestimo());
        return "emprestimos";
    }

    public String cancela() {
        return "listafilmes";
    }
    public String cancelaCliente() {
        return "listaclientes";
    }
    public String cancelaEmprestimo() {
        return "emprestimos";
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

    /**
     * @return the Cliente
     */
    public Cliente getCliente() {
        return Cliente;
    }

    /**
     * @param Cliente the Cliente to set
     */
    public void setCliente(Cliente Cliente) {
        this.Cliente = Cliente;
    }

    /**
     * @return the Emprestimo
     */
    public Emprestimo getEmprestimo() {
        return Emprestimo;
    }

    /**
     * @param Emprestimo the Emprestimo to set
     */
    public void setEmprestimo(Emprestimo Emprestimo) {
        this.Emprestimo = Emprestimo;
    }
}
