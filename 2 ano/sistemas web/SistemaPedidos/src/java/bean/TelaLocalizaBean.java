/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import persistencia.ClienteDAO;
import persistencia.PedidoDAO;
import persistencia.ProdutoDAO;
import vo.Cliente;
import vo.Pedido;
import vo.Produto;

/**
 *
 * @author 2info2021
 */
@ManagedBean
@RequestScoped
public class TelaLocalizaBean implements Serializable {

    private DataModel<Produto> listaproduto;
    ProdutoDAO prd = new ProdutoDAO();
    private Produto Produto = new Produto();
    private DataModel<Cliente> listacliente;
    ClienteDAO cd = new ClienteDAO();
    private Cliente Cliente = new Cliente();
    private DataModel<Pedido> listapedido;
    PedidoDAO ped = new PedidoDAO();
    private Pedido Pedido = new Pedido();

    public TelaLocalizaBean() {
    }

    public String atualizaListaProduto() {
        listaproduto = new ListDataModel(prd.pesquisa());
        return "listaproduto";
    }

    public String atualizaListaCliente() {
        listacliente = new ListDataModel(cd.pesquisa());
        return "listacliente";
    }

    public String atualizaListaPedido() {
        listapedido = new ListDataModel(ped.pesquisa());
        return "listapedido";
    }

    public DataModel<Produto> getListaProduto() {
        atualizaListaProduto();
        return listaproduto;
    }

    public DataModel<Cliente> getListaCliente() {
        atualizaListaCliente();
        return listacliente;
    }

    public DataModel<Pedido> getListaPedido() {
        atualizaListaPedido();
        return listapedido;
    }

    public Produto ProdutoSelecionado() {
        Produto pr = listaproduto.getRowData();
        return pr;
    }

    public Cliente ClienteSelecionado() {
        Cliente c = listacliente.getRowData();
        return c;
    }

    public Pedido PedidoSelecionado() {
        Pedido pe = listapedido.getRowData();
        return pe;
    }

    public String excluirProduto() {
        Produto p = ProdutoSelecionado();
        prd.exclui(p);
        return "listaproduto";
    }

    public String excluirCliente() {
        Cliente c = ClienteSelecionado();
        cd.exclui(c);
        return "listacliente";
    }

    public String novoProduto() {
        setProduto(new Produto());
        return "cadastroproduto";
    }

    public String novoCliente() {
        setCliente(new Cliente());
        return "cadastrocliente";
    }

    public String novoPedido() {
        setPedido(new Pedido());
        return "fazerpedido";
    }

    public String editarProduto() {
        Produto p = ProdutoSelecionado();
        setProduto(p);
        return "cadastroproduto";
    }

    public String editarCliente() {
        Cliente c = ClienteSelecionado();
        setCliente(c);
        return "cadastrocliente";
    }

    public String salvaProduto() {
        prd.salva(getProduto());
        return "listaproduto";
    }

    public String salvaCliente() {
        cd.salva(getCliente());
        return "listacliente";
    }

    public String salvaPedido() {
        if (cd.localiza(Pedido.getIdCliente()) != null) {
            if (prd.localiza(Pedido.getIdProduto()) != null) {
                if (Pedido.getQuantidade() > 0) {
                    ped.salva(getPedido());
                    return "listapedido";
                }
            }
        }
        return "";
    }

    public String cancelaProduto() {
        return "listaproduto";
    }

    public String cancelaCliente() {
        return "listacliente";
    }

    public String cancelaPedido() {
        return "listapedido";
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
     * @return the Pedido
     */
    public Pedido getPedido() {
        return Pedido;
    }

    /**
     * @param Pedido the Pedido to set
     */
    public void setPedido(Pedido Pedido) {
        this.Pedido = Pedido;
    }
}
