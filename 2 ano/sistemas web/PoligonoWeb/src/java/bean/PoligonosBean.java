/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import poligonos.Poligonos;
import javax.faces.bean.ManagedBean;


/**
 *
 * @author JP
 */
@ManagedBean
public class PoligonosBean {
    private Poligonos pol = new Poligonos();
    public String areaRetangulo(){
        getPol().areaRetangulo();
        return null;
    }
    public String perimetroRetangulo(){
        getPol().perimetroRetangulo();
        return null;
    }
    public String areaTriangulo(){
        getPol().areaTriangulo();
        return null;
    }
    /**
     * @return the pol
     */
    public Poligonos getPol() {
        return pol;
    }

    /**
     * @param pol the pol to set
     */
    public void setPol(Poligonos pol) {
        this.pol = pol;
    }
}
