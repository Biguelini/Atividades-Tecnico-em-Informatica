/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

/**
 *
 * @author 2info2021
 */
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Raquete {

    private int altura = 70;
    private int largura = 15;
    private Image imagem = new ImageIcon(getClass().getResource("/imagens/raquete.png")).getImage().getScaledInstance(getLargura(),
            getAltura(), 1);
    private double x;
    private double y;
    private double dy = 0;

    public Rectangle getLimites() {
        return new Rectangle((int) x, (int) y, largura, altura);
    }

    public Raquete(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void mexer() {
        setY(getY() + getDy());
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    public Image getImagem() {
        return imagem;
    }

    public void setImagem(Image imagem) {
        this.imagem = imagem;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

}
