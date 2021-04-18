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
import bd.BdSocio;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import vo.Socios;
@ManagedBean
@SessionScoped
public class SocioBean {
    private Socios socio;
    private final BdSocio bda=new BdSocio();
    private DataModel<Socios> lista;
    public SocioBean(){
        atualizaLista();
    }

    /**
     * @return the socio
     */
    public Socios getSocio() {
        return socio;
    }

    /**
     * @param socio the socio to set
     */
    public void setSocio(Socios socio) {
        this.socio = socio;
    }

    /**
     * @return the lista
     */
    public DataModel<Socios> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(DataModel<Socios> lista) {
        this.lista = lista;
    }
    public String salva(){
        bda.salva(socio);
        atualizaLista();
        return "socios";
    }
    public final void atualizaLista(){
        lista=new ListDataModel(bda.pesquisa(""));
    }
    public String exclui(){
        socio=lista.getRowData();
        bda.exclui(socio.getId());
        atualizaLista();
        return "";
    }
    public String novo(){
        socio=new Socios();
        return "cadastro_socio";
    }
    public String edita(){
        socio=lista.getRowData();
        return "cadastro_socio";
    }
}
