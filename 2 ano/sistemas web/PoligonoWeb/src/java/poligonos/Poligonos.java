/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poligonos;

/**
 *
 * @author JP
 */
public class Poligonos {

    /**
     * @return the base
     */
    public double getBase() {
        return base;
    }

    /**
     * @return the altura
     */
    public double getAltura() {
        return altura;
    }
    private double base;
    private double altura;
    private double resultado;
    /**
     * @param base the base to set
     */
    public void setBase(double base) {
        this.base = base;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(double altura) {
        this.altura = altura;
    }

    /**
     * @return the resultado
     */
    public double getResultado() {
        return resultado;
    }
    public void areaRetangulo(){
        resultado = getBase() * getAltura();
    }
    public void areaTriangulo(){
        resultado = (getBase() * getAltura())/2;
    }
    
    public void perimetroRetangulo(){
        resultado = (2*getBase()) + (2*getAltura());
    } 
    
}
