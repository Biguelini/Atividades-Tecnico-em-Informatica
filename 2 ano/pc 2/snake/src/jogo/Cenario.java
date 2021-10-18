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
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
public class Cenario {
    private int altura = 20;
    private int largura = 20;
    private int x = 0;
    private int y = 0;
    private Image fundo;
    public Cenario() {
          fundo = new ImageIcon(this.getClass().getResource("/imagens/cenario")).getImage().getScaledInstance(largura,altura, 1);
          x = 0;
          y = 0;
          largura = 0;
          altura = 0;
     }
     public Cenario(int x, int y, int largura, int altura) {
         this.x = x;
         this.y = y;
         this.largura = largura;        
         this.altura = altura;
         fundo = new ImageIcon(this.getClass().getResource("/imagens/cenario.png")).getImage().getScaledInstance(largura, altura, 1);
    }
    public Rectangle getLimites() {
         return new Rectangle((int) getX(), (int) getY(), largura, altura);
    }
    public int getAltura() {
         return altura;
    }
    public void setAltura(int altura) {
         this.altura = altura;
         fundo = new ImageIcon(this.getClass().getResource("/imagens/cenario")).getImage().getScaledInstance(largura, altura, 1);
    }
    public int getLargura() {
         return largura;
    }
    public void setLargura(int largura) {
         this.largura = largura;
         fundo = new ImageIcon(this.getClass().getResource("/imagens/cenario")).getImage().getScaledInstance(largura, altura, 1);
    }
    public Image getImagem() {
         return fundo;
    }
    public void setImagem(Image fundo) {
         this.fundo = fundo;
    }
    public int getX() {
         return x;
    }
    public void setX(int x) {
         this.x = x;
    }
    public int getY() {
         return y;
    }
    public void setY(int y) {
         this.y = y;
    }
}
