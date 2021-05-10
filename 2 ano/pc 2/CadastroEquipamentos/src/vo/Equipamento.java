/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

/**
 *
 * @author 2info2021
 */
public class Equipamento {

    private int id;
    private String descricao;
    private String fabricante; 
    private String numserie; 
    private int numpatrimonio; 
    private String localizacao;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the fabricante
     */
    public String getFabricante() {
        return fabricante;
    }

    /**
     * @param fabricante the fabricante to set
     */
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    /**
     * @return the numserie
     */
    public String getNumserie() {
        return numserie;
    }

    /**
     * @param numserie the numserie to set
     */
    public void setNumserie(String numserie) {
        this.numserie = numserie;
    }

    /**
     * @return the numpatrimonio
     */
    public int getNumpatrimonio() {
        return numpatrimonio;
    }

    /**
     * @param numpatrimonio the numpatrimonio to set
     */
    public void setNumpatrimonio(int numpatrimonio) {
        this.numpatrimonio = numpatrimonio;
    }

    /**
     * @return the localizacao
     */
    public String getLocalizacao() {
        return localizacao;
    }

    /**
     * @param localizacao the localizacao to set
     */
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
}
