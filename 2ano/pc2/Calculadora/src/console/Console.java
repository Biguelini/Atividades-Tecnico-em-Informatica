/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package console;

import calculadora.Calculadora;

/**
 *
 * @author JP
 */
public class Console {
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        calc.setValor1(6);
        calc.setValor2(3);
        calc.soma();
        System.out.println("A soma é "+calc.getResultado());
        calc.subtrai();
        System.out.println("A diferença é " + calc.getResultado());
        calc.divide();
        System.out.println("A divisão é " + calc.getResultado());
        calc.multiplica();
        System.out.println("A multiplicação é " + calc.getResultado());
    }
}
