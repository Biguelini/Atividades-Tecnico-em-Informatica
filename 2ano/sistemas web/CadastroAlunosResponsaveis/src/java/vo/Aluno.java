/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author JP
 */
@Entity
public class Aluno {

    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo = 0;
    private Integer idResponsavel;
    private String nome;
    private String filiacao;
    private String cpf;
    @Temporal(TemporalType.DATE)
    private Date datanasc;

    public Aluno(Integer codigo) {
        this.codigo = codigo;
    }

    public Aluno() {
    }

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }

    /**
     * @return the codigo
     */
    public Integer getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the idResponsavel
     */
    public Integer getIdResponsavel() {
        return idResponsavel;
    }

    /**
     * @param idResponsavel the idResponsavel to set
     */
    public void setIdResponsavel(Integer idResponsavel) {
        this.idResponsavel = idResponsavel;
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
     * @return the filiacao
     */
    public String getFiliacao() {
        return filiacao;
    }

    /**
     * @param filiacao the filiacao to set
     */
    public void setFiliacao(String filiacao) {
        this.filiacao = filiacao;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the datanasc
     */
    public Date getDatanasc() {
        return datanasc;
    }

    /**
     * @param datanasc the datanasc to set
     */
    public void setDatanasc(Date datanasc) {
        this.datanasc = datanasc;
    }
}
