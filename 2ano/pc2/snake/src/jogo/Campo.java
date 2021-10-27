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
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Campo extends JPanel implements ActionListener {

    Fruta fruta;
    Cobra cobra;
    Cobra corpo[] = new Cobra[1000];
    Cenario cenario[] = new Cenario[10];
    int tamanhocenario = 4;
    int tamanho = 3;
    Timer t;
    Image fundo;
    int vida = 3;
    String msg = "";

    TocaAudio tocaAudio = new TocaAudio("/som/musica.mp3");

    public Campo(int largura, final int altura) {
        setFocusable(true);
        setDoubleBuffered(true);
        setSize(largura, altura);
        fundo = new ImageIcon(this.getClass().getResource("/imagens/campo.jpg")).getImage().getScaledInstance(largura, altura, 1);
        inicializa();
        repaint();
        t = new Timer(100, this);
        t.start();
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int tecla = e.getKeyCode();
                if (tecla == KeyEvent.VK_UP) {
                    cobra.setDy(-20);
                    cobra.setDx(0);
                }
                if (tecla == KeyEvent.VK_DOWN) {
                    cobra.setDy(20);
                    cobra.setDx(0);
                }
                if (tecla == KeyEvent.VK_LEFT) {
                    cobra.setDx(-20);
                    cobra.setDy(0);
                }
                if (tecla == KeyEvent.VK_RIGHT) {
                    cobra.setDx(20);
                    cobra.setDy(0);
                }
                if (tecla == 'P' || tecla == 'p') {
                    if (t.isRunning()) {
                        msg = "Pausa";
                        repaint();
                        t.stop();
                    } else {
                        t.restart();
                        msg = "";
                    }
                }
                if (tecla == 'r' || tecla == 'R') {
                    inicializa();
                    t.start();
                }
                if (tecla == KeyEvent.VK_SPACE && vida == 0) {
                    msg = "";
                    t.start();
                }

            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!tocaAudio.isAlive()) {
            tocaAudio.start();
        }
        for (int i = tamanho - 1; i > 0; i--) {
            corpo[i].setX(corpo[i - 1].getX());
            corpo[i].setY(corpo[i - 1].getY());
        }
        corpo[0].setX(cobra.getX());
        corpo[0].setY(cobra.getY());
        cobra.mexer();
        if (verificaColisaoFruta(fruta, cobra)) {
            corpo[tamanho++] = new Cobra();
            posicionaFruta();
        }
        if (verificaColisaoCorpo()) {
            t.stop();
            msg = "Game Over";
        }
        if (verificaColisaoCenario()) {
            t.stop();
            msg = "Game Over";
        }

        repaint();
    }

    private void posicionaFruta() {
        boolean ok = false;
        int x, y;
        while (!ok) {
            ok = true;
            x = new Random().nextInt(this.getWidth());
            y = new Random().nextInt(this.getHeight());
            fruta = new Fruta(x, y);
            if (verificaColisaoFruta(fruta, cobra)) {
                ok = false;
            }
            for (int i = 0; i < tamanho; i++) {
                if (verificaColisaoFruta(fruta, corpo[i])) {
                    ok = false;
                }
            }
            for (int i = 0; i < tamanhocenario; i++) {
                if (verificaColisaoFruta(fruta, cenario[i])) {
                    ok = false;
                }
            }
        }
    }

    private void inicializa() {
        cobra = new Cobra(500, 400);
        cobra.setDx(-20);
        corpo[0] = new Cobra(520, 400);
        corpo[1] = new Cobra(540, 400);
        corpo[2] = new Cobra(560, 400);
        msg = "";
        tamanho = 3;

        cenario1();
        posicionaFruta();

    }

    private boolean verificaColisaoFruta(Fruta f, Cobra c) {
        if (c.getLimites().intersects(f.getLimites())) {
            return true;
        } else {
            return false;
        }
    }

    private boolean verificaColisaoFruta(Fruta f, Cenario c) {
        if (f.getLimites().intersects(c.getLimites())) {
            return true;
        } else {
            return false;
        }
    }

    private boolean verificaColisaoCorpo() {
        for (int i = 0; i < tamanho; i++) {
            if (cobra.getLimites().intersects(corpo[i].getLimites())) {
                return true;
            }
        }
        return false;
    }

    private boolean verificaColisaoCenario() {
        for (int i = 0; i < tamanhocenario; i++) {
            if (cobra.getLimites().intersects(cenario[i].getLimites())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(fundo, 0, 0, null);
        g.setColor(Color.WHITE);
        g.drawImage(cobra.getImagem(), (int) cobra.getX(), (int) cobra.getY(), this);
        for (int i = 0; i < tamanho; i++) {
            g.drawImage(corpo[i].getImagem(), (int) corpo[i].getX(), (int) corpo[i].getY(), this);
        }
        for (int i = 0; i < tamanhocenario; i++) {
            g.drawImage(cenario[i].getImagem(), (int) cenario[i].getX(), (int) cenario[i].getY(), this);
        }
        g.drawImage(fruta.getImagem(), (int) fruta.getX(), (int) fruta.getY(), this);
        Font f = new Font("Arial", Font.BOLD, 20);
        g.setFont(f);
        FontMetrics fm = g.getFontMetrics(f);
        Rectangle2D rect = fm.getStringBounds(msg, g);
        int textWidth = (int) (rect.getWidth());
        int panelWidth = this.getWidth();
        int x = (panelWidth - textWidth) / 2;
        g.drawString(msg, x, 3 * (this.getHeight() / 4));
    }

    private void cenario1() {
        cenario[0] = new Cenario(0, 0, 25, 700);
        cenario[1] = new Cenario(0, 0, 1000, 25);
        cenario[2] = new Cenario(0, 680, 1000, 25);
        cenario[3] = new Cenario(970, 0, 25, 700);
        cenario[4] = new Cenario(200, 100, 25, 500);
        cenario[5] = new Cenario(770, 100, 25, 500);
        tamanhocenario = 6;
    }
}
