/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

/**
 *
 * @author JP
 */
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
public class Cobra {

    private int altura = 20;
    private int largura = 20;
    private Image imagem = new ImageIcon(getClass().getResource("/imagens/cobra.png")).getImage().getScaledInstance(largura,
            altura, 1);
    private Image imagemP = new ImageIcon(getClass().getResource("/imagens/cobrap.png")).getImage().getScaledInstance(largura,
            altura, 1);
    private Image imagemCabeca = new ImageIcon(getClass().getResource("/imagens/cabeca.png")).getImage().getScaledInstance(largura,
            altura, 1);
    private double x;
    private double y;
    private int dx = 0;
    private int dy = 0;

    public Rectangle getLimites() {
        return new Rectangle((int) x, (int) y, largura, altura);
    }

    public Cobra(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Cobra() {
        x = 0;
        y = 0;
    }

    public void mexer() {
        x += dx;
        y += dy;
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

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    /**
     * @return the imagemCabeca
     */
    public Image getImagemCabeca() {
        return imagemCabeca;
    }

    /**
     * @param imagemCabeca the imagemCabeca to set
     */
    public void setImagemCabeca(Image imagemCabeca) {
        this.imagemCabeca = imagemCabeca;
    }

    /**
     * @return the imagemP
     */
    public Image getImagemP() {
        return imagemP;
    }

    /**
     * @param imagemP the imagemP to set
     */
    public void setImagemP(Image imagemP) {
        this.imagemP = imagemP;
    }
}
