/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author 2info2021
 */
public class Labirinto extends JPanel implements ActionListener {

    Ghost ghost[] = new Ghost[4];
    PacMan pacman;
    String msg = "";
    Timer t;
    int seq = 0, ponto = 0, comida = 0, tempovulneravel = 0, vida = 3, record;
    char labirinto[][];
    int altura, largura, passoX, passoY;

    public Labirinto(int largura, int altura) {
        setFocusable(true);
        setDoubleBuffered(true);
        setSize(largura, altura);
        this.altura = altura;
        this.largura = largura;
        passoX = largura / 19;
        passoY = altura / 21;
        t = new Timer(50, this);

        ponto = 0;
        for (int i = 0; i < 4; i++) {
            ghost[i] = new Ghost(i, passoX, passoY);
        }
        pacman = new PacMan(passoX, passoY);
        inicializa();
        try {
            FileReader arq = new FileReader("record.cfg");
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine();
            arq.close();
            if (linha != null) {
                record = Integer.parseInt(linha);
            } else {
                record = 0;
            }
        } catch (IOException e) {
            record = 0;
        }
        t.start();
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int tecla = e.getKeyCode();
                if (tecla == KeyEvent.VK_LEFT) {
                    pacman.setDx(-1);
                    pacman.setDy(0);
                }
                if (tecla == KeyEvent.VK_RIGHT) {
                    pacman.setDx(1);
                    pacman.setDy(0);
                }
                if (tecla == KeyEvent.VK_UP) {
                    pacman.setDx(0);
                    pacman.setDy(-1);
                }
                if (tecla == KeyEvent.VK_DOWN) {
                    pacman.setDx(0);
                    pacman.setDy(1);
                }
                if (tecla == KeyEvent.VK_HOME) {
                    for (int i = 0; i < 4; i++) {
                        ghost[i].setStatus(1);
                    }
                }
                if ((tecla == 'P' || tecla == 'p') && vida > 0) {
                    if (t.isRunning()) {
                        msg = "Pausa";
                        repaint();
                        t.stop();
                    } else {
                        msg = "";
                        t.restart();
                    }
                }
                if (tecla == KeyEvent.VK_ESCAPE) {
                    repaint();
                    t.stop();
                    if (JOptionPane.showConfirmDialog(null, "Deseja realmente sair", "Sair", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        System.exit(0);
                    } else {
                        t.restart();
                    }
                }
                if ((tecla == 'C' || tecla == 'c') && vida > 0) {
                    msg = "";
                    t.restart();
                }
                if ((tecla == 'R' || tecla == 'r')) {
                    vida = 3;
                    ponto = 0;
                    inicializa();
                    msg = "";
                    t.restart();
                }
            }
        });
    }

    private void inicializa() {
        comida = 0;
        inicializaLabirinto();
        for (int i = 0; i < 4; i++) {
            ghost[i].setX(9);
            ghost[i].setY(10);
            ghost[i].setStatus(0);
        }
        pacman.setX(9);
        pacman.setY(16);
        pacman.setDx(1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tempovulneravel++;
        if (labirinto[pacman.getY()][pacman.getX()] == 'c') {
            labirinto[pacman.getY()][pacman.getX()] = ' ';
            ponto++;
            comida++;
        }
        for (int i = 0; i < 4; i++) {
            if (ghost[i].getStatus() == 1 && tempovulneravel > 200) {
                ghost[i].setStatus(0);
            }
        }
        if (labirinto[pacman.getY()][pacman.getX()] == 'o') {
            labirinto[pacman.getY()][pacman.getX()] = ' ';
            tempovulneravel = 0;
            ponto += 5;
            for (int i = 0; i < 4; i++) {
                if (ghost[i].getStatus() == 0) {
                    ghost[i].setStatus(1);
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            if (ghost[i].getX() == pacman.getX() && ghost[i].getY() == pacman.getY()) {

                if (ghost[i].getStatus() == 0) {
                    vida--;
                    if (vida > 0) {
                        pacman.setX(9);
                        pacman.setY(16);
                        pacman.setDx(1);
                        for (int j = 0; j < 4; j++) {
                            ghost[j].setX(9);
                            ghost[j].setY(10);
                        }
                        msg = "Pressione C para continuar!";
                        repaint();
                        t.stop();
                    }

                } else {
                    ponto += 10;
                    ghost[i].setStatus(2);
                }

            }
        }
        if (vida <= 0) {
            msg = "Game over";
            verificaRecord();
            repaint();
            t.stop();
        }
        if (seq == 0) {
            mexerFantasma();
        }
        if (labirinto[pacman.getY() + pacman.getDy()][pacman.getX() + pacman.getDx()] != 'p' && (seq == 0 || seq == 3)) {
            pacman.move();
        }
        if (comida == 159) {
            inicializa();
        }
        seq++;
        if (seq == 8) {
            seq = 0;
        }
        repaint();
    }

    private void verificaRecord() {
        try {
            if (ponto > record) {
                BufferedWriter bw = new BufferedWriter(new FileWriter("record.cfg", false));
                bw.write(Integer.toString(ponto));
                bw.close();
                record = ponto;
            }
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo\n");
        }
    }

    private void mexerFantasma() {
        int i = 0;
        for (i = 0; i < 4; i++) {
            int sorteio = new Random().nextInt(100);
            if (ghost[i].getStatus() == 0) {
                if (labirinto[ghost[i].getY() + ghost[i].getDy()][ghost[i].getX() + ghost[i].getDx()] != 'p') {
                    ghost[i].move();
                    if (ghost[i].getDx() != 0) {
                        int dire = new Random().nextInt(3) - 1;
                        while (dire == 0) {
                            dire = new Random().nextInt(3) - 1;
                        }
                        if (labirinto[ghost[i].getY() + dire][ghost[i].getX()] != 'p' && sorteio > 50) {
                            ghost[i].setDy(dire);
                            ghost[i].setDx(0);
                        }
                    } else {
                        int dire = new Random().nextInt(3) - 1;
                        while (dire == 0) {
                            dire = new Random().nextInt(3) - 1;
                        }
                        if (labirinto[ghost[i].getY()][ghost[i].getX() + dire] != 'p' && sorteio > 50) {
                            ghost[i].setDx(dire);
                            ghost[i].setDy(0);
                        }
                    }
                } else {
                    if (ghost[i].getDx() != 0) {
                        int dire = (int) Math.signum(pacman.getY() - ghost[i].getY());
                        while (dire == 0) {
                            dire = new Random().nextInt(3) - 1;
                        }
                        if (labirinto[ghost[i].getY() + dire][ghost[i].getX()] != 'p') {
                            ghost[i].setDy(dire);
                            ghost[i].setDx(0);
                        } else {
                            ghost[i].setDy(-dire);
                            ghost[i].setDx(0);
                        }
                    } else {
                        int dire = (int) Math.signum(pacman.getX() - ghost[i].getX());
                        while (dire == 0) {
                            dire = new Random().nextInt(3) - 1;
                        }
                        if (labirinto[ghost[i].getY()][ghost[i].getX() + dire] != 'p') {
                            ghost[i].setDx(dire);
                            ghost[i].setDy(0);
                        } else {
                            ghost[i].setDx(-dire);
                            ghost[i].setDy(0);
                        }
                    }
                }
            }
            if (ghost[i].getStatus() == 1) {
                if (labirinto[ghost[i].getY() + ghost[i].getDy()][ghost[i].getX() + ghost[i].getDx()] != 'p') {
                    ghost[i].move();
                    if (ghost[i].getDx() != 0) {
                        int dire = new Random().nextInt(3) - 1;
                        while (dire == 0) {
                            dire = new Random().nextInt(3) - 1;
                        }
                        if (labirinto[ghost[i].getY() + dire][ghost[i].getX()] != 'p' && sorteio > 50) {
                            ghost[i].setDy(dire);
                            ghost[i].setDx(0);
                        }
                    } else {
                        int dire = new Random().nextInt(3) - 1;
                        while (dire == 0) {
                            dire = new Random().nextInt(3) - 1;
                        }
                        if (labirinto[ghost[i].getY()][ghost[i].getX() + dire] != 'p' && sorteio > 50) {
                            ghost[i].setDx(dire);
                            ghost[i].setDy(0);
                        }
                    }
                } else {
                    if (ghost[i].getDx() != 0) {
                        int dire = -(int) Math.signum(pacman.getY() - ghost[i].getY());
                        while (dire == 0) {
                            dire = new Random().nextInt(3) - 1;
                        }
                        if (labirinto[ghost[i].getY() + dire][ghost[i].getX()] != 'p') {
                            ghost[i].setDy(dire);
                            ghost[i].setDx(0);
                        } else {
                            ghost[i].setDy(-dire);
                            ghost[i].setDx(0);
                        }
                    } else {
                        int dire = -(int) Math.signum(pacman.getX() - ghost[i].getX());
                        while (dire == 0) {
                            dire = new Random().nextInt(3) - 1;
                        }
                        if (labirinto[ghost[i].getY()][ghost[i].getX() + dire] != 'p') {
                            ghost[i].setDx(dire);
                            ghost[i].setDy(0);
                        } else {
                            ghost[i].setDx(-dire);
                            ghost[i].setDy(0);
                        }
                    }
                }
            }
            if (ghost[i].getStatus() == 2) {
                ghost[i].setDx((int) Math.signum(9 - ghost[i].getX()));
                ghost[i].setDy((int) Math.signum(10 - ghost[i].getY()));
                ghost[i].move();
                if (ghost[i].getX() == 9 && ghost[i].getY() == 10) {
                    ghost[i].setStatus(0);
                }
            }
        }
    }

    private void inicializaLabirinto() {
        char lab[][] = {
            {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
            {'p', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'p', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'p'},
            {'p', 'o', 'p', 'p', 'c', 'p', 'p', 'p', 'c', 'p', 'c', 'p', 'p', 'p', 'c', 'p', 'p', 'o', 'p'},
            {'p', 'c', 'p', 'p', 'c', 'p', 'p', 'p', 'c', 'p', 'c', 'p', 'p', 'p', 'c', 'p', 'p', 'c', 'p'},
            {'p', 'c', 'c', 'c', 'c', 'c', 'c', 'p', 'c', 'c', 'c', 'p', 'c', 'c', 'c', 'c', 'c', 'c', 'p'},
            {'p', 'c', 'p', 'p', 'p', 'p', 'c', 'p', 'p', 'p', 'p', 'p', 'c', 'p', 'p', 'p', 'p', 'c', 'p'},
            {'p', 'c', 'c', 'c', 'c', 'p', 'c', 'c', 'c', 'p', 'c', 'c', 'c', 'p', 'c', 'c', 'c', 'c', 'p'},
            {'p', 'p', 'p', 'p', 'c', 'p', 'p', 'p', 'c', 'p', 'c', 'p', 'p', 'p', 'c', 'p', 'p', 'p', 'p'},
            {' ', ' ', ' ', 'p', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'p', ' ', ' ', ' '},
            {' ', ' ', ' ', 'p', 'c', 'p', 'c', 'p', 'p', '-', 'p', 'p', 'c', 'p', 'c', 'p', ' ', ' ', ' '},
            {' ', ' ', ' ', 'p', 'c', 'p', 'c', 'p', 'p', ' ', 'p', 'p', 'c', 'p', 'c', 'p', ' ', ' ', ' '},
            {' ', ' ', ' ', 'p', 'c', 'p', 'c', 'p', 'p', '-', 'p', 'p', 'c', 'p', 'c', 'p', ' ', ' ', ' '},
            {' ', ' ', ' ', 'p', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'p', ' ', ' ', ' '},
            {'p', 'p', 'p', 'p', 'c', 'p', 'p', 'p', 'c', 'p', 'c', 'p', 'p', 'p', 'c', 'p', 'p', 'p', 'p'},
            {'p', 'c', 'c', 'c', 'c', 'p', 'c', 'c', 'c', 'p', 'c', 'c', 'c', 'p', 'c', 'c', 'c', 'c', 'p'},
            {'p', 'c', 'p', 'p', 'p', 'p', 'c', 'p', 'p', 'p', 'p', 'p', 'c', 'p', 'p', 'p', 'p', 'c', 'p'},
            {'p', 'c', 'c', 'c', 'c', 'c', 'c', 'p', 'c', ' ', 'c', 'p', 'c', 'c', 'c', 'c', 'c', 'c', 'p'},
            {'p', 'c', 'p', 'p', 'c', 'p', 'p', 'p', 'c', 'p', 'c', 'p', 'p', 'p', 'c', 'p', 'p', 'c', 'p'},
            {'p', 'o', 'p', 'p', 'c', 'p', 'p', 'p', 'c', 'p', 'c', 'p', 'p', 'p', 'c', 'p', 'p', 'o', 'p'},
            {'p', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'p', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'p'},
            {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},};
        labirinto = lab;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, largura, altura);
        for (int y = 0; y < 21; y++) {
            for (int x = 0; x < 19; x++) {
                switch (labirinto[y][x]) {
                    case 'p':
                        g.setColor(Color.BLUE);
                        g.fillRect(x * passoX, y * passoY, passoX, passoY);
                        break;
                    case 'c':
                        g.setColor(Color.YELLOW);
                        g.fillArc(x * passoX + (passoX / 3), y * passoY + (passoY / 3), passoX / 2, passoY / 2, 0, 360);
                        break;
                    case 'o':
                        g.setColor(Color.RED);
                        g.fillArc(x * passoX + (passoX / 3), y * passoY + (passoY / 3), passoX / 2, passoY / 2, 0, 360);
                        break;
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            g.drawImage(ghost[i].getImagem(), ghost[i].getX() * passoX, ghost[i].getY() * passoY, this);
        }
        g.drawImage(pacman.getImagem(), pacman.getX() * passoX, pacman.getY() * passoY, this);
        g.setColor(Color.WHITE);
        Font f = new Font("Arial", Font.BOLD, 20);
        g.setFont(f);
        FontMetrics fm = g.getFontMetrics(f);
        Rectangle2D rect = fm.getStringBounds(msg, g);
        int textWidth = (int) (rect.getWidth());
        int panelWidth = this.getWidth();
        int x = (panelWidth - textWidth) / 2;
        g.drawString(msg, x, 3 * (this.getHeight() / 4));
        g.drawString("Vidas:" + vida + " Pontos:" + ponto + " Record:" + record, 100, passoY);
    }
}
