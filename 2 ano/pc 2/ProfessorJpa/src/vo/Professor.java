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
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Professor {
    @Id
    @GeneratedValue
    private int codigo = 0;
    private String nome;
    @Temporal(TemporalType.DATE)
    private Calendar datanasc;
    private String formacao;

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

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
     * @return the datanasc
     */
    public Calendar getDatanasc() {
        return datanasc;
    }

    /**
     * @param datanasc the datanasc to set
     */
    public void setDatanasc(Calendar datanasc) {
        this.datanasc = datanasc;
    }

    /**
     * @return the formacao
     */
    public String getFormacao() {
        return formacao;
    }

    /**
     * @param formacao the formacao to set
     */
    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }
}
