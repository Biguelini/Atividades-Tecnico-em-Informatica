/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fcsa0719
 */
public class Fibonacci {
    private int n1 = 0;
    private int n2 = 1;
    private int swap;
    private int qtd;
        public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        f.calcular(70000);
    }
    public void calcular(int num){
        while(num>0){
            System.out.println(getN1()+getN2()+" ");
            setSwap(getN1()+getN2());
            setN1(getN2());
            setN2(getSwap());
            num = num - 1;
        }
        
    }

    public int getN1() {
        return n1;
    }


    public void setN1(int n1) {
        this.n1 = n1;
    }


    public int getN2() {
        return n2;
    }


    public void setN2(int n2) {
        this.n2 = n2;
    }


    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public int getSwap() {
        return swap;
    }
    public void setSwap(int swap) {
        this.swap = swap;
    }
    
}
