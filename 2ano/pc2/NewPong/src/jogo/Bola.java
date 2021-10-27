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
import java.util.Random;
import javax.swing.ImageIcon;
public class Bola {

    private int altura = 20;
    private int largura = 20;
    private Image imagem = new ImageIcon(getClass().getResource("/imagens/bola.png")).getImage().getScaledInstance(getLargura(),
            getAltura(), 1);
    private double x;
    private double y;
    private double dx = 15;
    private double dy = new Random().nextDouble() * 5 - 2.5;

    
    
    public Bola(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Rectangle getLimites() {
        return new Rectangle((int) getX(), (int) getY(), getLargura(), getAltura());
    }

    public void mexer() {
        setX(getX() + getDx());
        setY(getY() + getDy());
    }

    /**
     * @return the altura
     */
    public int getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(int altura) {
        this.altura = altura;
    }

    /**
     * @return the largura
     */
    public int getLargura() {
        return largura;
    }

    /**
     * @param largura the largura to set
     */
    public void setLargura(int largura) {
        this.largura = largura;
    }

    /**
     * @return the imagem
     */
    public Image getImagem() {
        return imagem;
    }

    /**
     * @param imagem the imagem to set
     */
    public void setImagem(Image imagem) {
        this.imagem = imagem;
    }

    /**
     * @return the x
     */
    public double getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public double getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * @return the dx
     */
    public double getDx() {
        return dx;
    }

    /**
     * @param dx the dx to set
     */
    public void setDx(double dx) {
        this.dx = dx;
    }

    /**
     * @return the dy
     */
    public double getDy() {
        return dy;
    }

    /**
     * @param dy the dy to set
     */
    public void setDy(double dy) {
        this.dy = dy;
    }

}
