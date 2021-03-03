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
        resultado = base * altura;
    }
    public void areaTriangulo(){
        resultado = (base * altura)/2;
    }
    
    public void perimetroRetangulo(){
        resultado = (2*base) + (2*altura);
    } 
    
}
