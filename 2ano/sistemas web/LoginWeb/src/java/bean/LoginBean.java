/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import vo.Login;

/**
 *
 * @author JP
 */
@ManagedBean
@SessionScoped
public class LoginBean {
    private Login login = new Login(); 
    private boolean loginok=false;
    public String loga(){
        if(login.getUsuario().equals("joao")&& login.getSenha().equals("senhaforte")){
            loginok = true;
            return "inicio";
        
        } else{
            loginok = false;
            return "erro";
        }
    }
    
    public String desloga(){
        login = new Login();
        return "index";
    }
    
    /**
     * @return the login
     */
    public Login getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(Login login) {
        this.login = login;
    }

    /**
     * @return the loginok
     */
    public boolean isLoginok() {
        return loginok;
    }

    /**
     * @param loginok the loginok to set
     */
    public void setLoginok(boolean loginok) {
        this.loginok = loginok;
    }
}
