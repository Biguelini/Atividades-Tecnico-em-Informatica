/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

/**
 *
 * @author JP
 */
public class Usuario {
    private String nome;
    private String user;
    private String senha;

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the Senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha
     * @param Senha the Senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
