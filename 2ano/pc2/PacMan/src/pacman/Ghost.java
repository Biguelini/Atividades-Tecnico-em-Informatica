/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

/**
 *
 * @author 2info2021
 */
import java.awt.Image;
import javax.swing.ImageIcon;

public class Ghost extends Thread {

    private int num = 1;
    private Image imagem = new ImageIcon(getClass().getResource("/imagens/ghost_1_0.png")).getImage().getScaledInstance(20, 20, 0);
    private int status = 0;
    private int dx = 0;
    private int dy = 0;
    private int x = 0;
    private int y = 0;
    private int altura = 20;
    private int largura = 20;
    int seq = 0;

    /**
     * @return the num
     */
    public int getNum() {
        return num;
    }

    /**
     * @param num the num to set
     */
    public void setNum(int num) {
        this.num = num;
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
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the dx
     */
    public int getDx() {
        return dx;
    }

    /**
     * @param dx the dx to set
     */
    public void setDx(int dx) {
        this.dx = dx;
    }

    /**
     * @return the dy
     */
    public int getDy() {
        return dy;
    }

    /**
     * @param dy the dy to set
     */
    public void setDy(int dy) {
        this.dy = dy;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
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

    public Ghost(int num, int largura, int altura) {
        this.num = num;
        this.largura = largura;
        this.altura = altura;
        switch (num) {
            case 0:
                dx = 1;
                break;
            case 1:
                dy = 1;
                break;
            case 2:
                dx = -1;
                break;
            case 3:
                dy = -1;
        }
        start();
    }

    public void move() {
        x += dx;
        y += dy;
    }

    @Override
    public void run() {
        while (true) {
            switch (status) {
                case 0:
                    if (seq > 7) {
                        seq = 0;
                    }
                    imagem = new ImageIcon(getClass().getResource("/imagens/ghost_" + num + "_" + seq + ".png")).getImage().getScaledInstance((int) largura, (int) altura, 0);
                    break;
                case 1:
                    if (seq > 3) {
                        seq = 0;
                    }
                    imagem = new ImageIcon(getClass().getResource("/imagens/ghost_vulnerable_" + seq + ".png")).getImage().getScaledInstance((int) largura, (int) altura, 0);
                    break;
                case 2:
                    if (seq > 3) {
                        seq = 0;
                    }
                    imagem = new ImageIcon(getClass().getResource("/imagens/ghost_died_" + seq + ".png")).getImage().getScaledInstance((int) largura, (int) altura, 0);
                    break;
            }
            seq++;
            try{
                this.sleep(50);
            } catch (Exception e){
                System.out.println("Erro:"+e.getMessage());
            }
        }
    }
}
