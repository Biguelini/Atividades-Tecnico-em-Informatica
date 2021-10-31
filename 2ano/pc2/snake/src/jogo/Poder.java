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
import java.util.Random;
import javax.swing.ImageIcon;
public class Poder {
     private int altura = 20;
    private int largura = 20;
    private Image imagem = new ImageIcon(getClass().getResource("/imagens/poder.png")).getImage().getScaledInstance(getLargura(), getAltura(), 1);
     private double x;
     private double y;
     public Poder(int x, int y) {
         this.x = x;
         this.y = y;
     }
     public Rectangle getLimites() {
         return new Rectangle((int) x, (int) y, largura, altura);
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
}
