/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.faces.bean.ManagedBean;
import vo.Cadastro;

/**
 *
 * @author JP
 */
@ManagedBean
public class CadastroBean {
    private Cadastro cadastro = new Cadastro();

    /**
     * @return the cadastro
     */
    public Cadastro getCadastro() {
        return cadastro;
    }

    /**
     * @param cadastro the cadastro to set
     */
    public void setCadastro(Cadastro cadastro) {
        this.cadastro = cadastro;
    }
    
}
