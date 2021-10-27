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
public class Disciplinas {
    private int codigo;
    private String nome;
    private int cargahoraria;
    private String professor;

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
     * @return the cargahoraria
     */
    public int getCargahoraria() {
        return cargahoraria;
    }

    /**
     * @param cargahoraria the cargahoraria to set
     */
    public void setCargahoraria(int cargahoraria) {
        this.cargahoraria = cargahoraria;
    }

    /**
     * @return the professor
     */
    public String getProfessor() {
        return professor;
    }

    /**
     * @param professor the professor to set
     */
    public void setProfessor(String professor) {
        this.professor = professor;
    }
    
}
