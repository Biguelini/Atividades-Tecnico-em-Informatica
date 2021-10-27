/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package calculadora;

/**
 *
 * @author JP
 */
public class Calculadora {
    private double valor1;
    private double valor2;
    private double resultado;
    public void soma(){
        resultado = valor1 + valor2;
    }
    public void subtrai(){
        resultado = valor1 - valor2;
    }
    public void multiplica(){
        resultado = valor1 * valor2;
    }
    public void divide(){
        resultado = valor1 / valor2;
    }
    
    /**
     * @return the valor1
     */
    public double getValor1() {
        return valor1;
    }

    /**
     * @param valor1 the valor1 to set
     */
    public void setValor1(double valor1) {
        this.valor1 = valor1;
    }

    /**
     * @return the valor2
     */
    public double getValor2() {
        return valor2;
    }

    /**
     * @param valor2 the valor2 to set
     */
    public void setValor2(double valor2) {
        this.valor2 = valor2;
    }

    /**
     * @return the resultado
     */
    public double getResultado() {
        return resultado;
    }

    /**
     * @param resultado the resultado to set
     */
    public void setResultado(double resultado) {
        this.resultado = resultado;
    }
}
