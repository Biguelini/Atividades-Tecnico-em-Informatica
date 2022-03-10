/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base2d;

/**
 *
 * @author 2info2021
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Painel extends JPanel implements ActionListener {

    JButton bSair;
    JFrame tela;
    Desenho desenho = new Desenho();
    double mx, my;

    public Painel(int largura, final int altura, JFrame t) {
        tela = t;
        setFocusable(true);
        setDoubleBuffered(true);
        setSize(largura, altura);
        inicializa();
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int tecla = e.getKeyCode();
                Color cor = tela.getForeground();
                tela.setForeground(tela.getBackground());
                desenho.desenha(tela.getGraphics());
                System.out.println(tecla);
                switch (tecla) {
                    case KeyEvent.VK_LEFT:
                        desenho.translada(-1, 0);
                        break;
                    case KeyEvent.VK_UP:

                        desenho.translada(0, -1);
                        break;
                    case KeyEvent.VK_RIGHT:
                        desenho.translada(1, 0);
                        break;
                    case KeyEvent.VK_DOWN:
                        desenho.translada(0, 1);
                        break;
                    case KeyEvent.VK_W:
                        mx = desenho.getMouseX();
                        my = desenho.getMouseY();
                        desenho.translada(-mx, -my);
                        desenho.rotaciona(0.1);
                        desenho.translada(mx, my);
                        break;
                    case KeyEvent.VK_Q:
                        mx = desenho.getMouseX();
                        my = desenho.getMouseY();
                        desenho.translada(-mx, -my);
                        desenho.rotaciona(-0.1);
                        desenho.translada(mx, my);
                        break;
                    case KeyEvent.VK_A:
                        desenho.deforma(true);
                        break;
                    case KeyEvent.VK_S:
                        desenho.deforma(false);
                        break;
                }
                tela.setForeground(cor);
                desenho.desenha(tela.getGraphics());
            }
        });

        this.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                desenho.setMouse(x, y);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    private void inicializa() {
        setBackground(Color.black);
        setForeground(Color.white);
        bSair = new JButton();
        bSair.setText("Sair");
        GroupLayout layout = new GroupLayout(tela.getContentPane());
        tela.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(0, 327, Short.MAX_VALUE).addComponent(bSair)));
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(bSair).addGap(0, 277, Short.MAX_VALUE)));
        bSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tela.dispose();
            }
        });
        desenho.setMundo(0, 0, 20, 20);
        desenho.setViewPort(0, 0, 1, 1);
        desenho.rosto();
    }

    @Override
    public void paint(Graphics g) {
        Dimension dim = this.getSize();
        desenho.setDimension(dim);
        desenho.desenha(g);
    }
}
