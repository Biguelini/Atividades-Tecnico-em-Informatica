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
public class Aluno {

    private int codigo;
    private String nome;
    private int serie;
    private String turma;

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
     * @return the serie
     */
    public int getSerie() {
        return serie;
    }

    /**
     * @param serie the serie to set
     */
    public void setSerie(int serie) {
        this.serie = serie;
    }

    /**
     * @return the turma
     */
    public String getTurma() {
        return turma;
    }

    /**
     * @param turma the turma to set
     */
    public void setTurma(String turma) {
        this.turma = turma;
    }
}
