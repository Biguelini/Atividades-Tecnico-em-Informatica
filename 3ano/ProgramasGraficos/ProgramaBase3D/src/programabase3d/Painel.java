/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programabase3d;

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
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author 2info2021
 */
public class Painel extends JPanel implements ActionListener {

    JCheckBox cX, cY, cZ;
    JButton bSair;
    JFrame tela;
    Desenho3D desenho = new Desenho3D();
    double mx, my;

    public Painel(int largura, final int altura, JFrame t) {
        tela = t;
        setFocusable(true);
        setDoubleBuffered(true);
        setSize(largura, altura);
        inicializa();
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int tecla = e.getKeyCode();
                Color cor = tela.getForeground();
                tela.setForeground(tela.getBackground());
                desenho.desenha(tela.getGraphics());
                repaint();
                switch (tecla) {
                    case KeyEvent.VK_LEFT:
                        desenho.translada(-1, 0, 0);
                        break;
                    case KeyEvent.VK_UP:
                        desenho.translada(0, -1, 0);
                        break;
                    case KeyEvent.VK_RIGHT:
                        desenho.translada(1, 0, 0);
                        break;
                    case KeyEvent.VK_DOWN:
                        desenho.translada(0, 1, 0);
                        break;
                    case KeyEvent.VK_PAGE_DOWN:
                        desenho.translada(0, 0, -1);
                        break;
                    case KeyEvent.VK_PAGE_UP:
                        desenho.translada(0, 0, 1);
                        break;
                    case KeyEvent.VK_W:
                        double rh = cX.isSelected() ? 0.1 : 0;
                        double rb = cY.isSelected() ? 0.1 : 0;
                        double ry = cZ.isSelected() ? 0.1 : 0;
                        desenho.translada(-desenho.getCentrox(), -desenho.getCentroy(), 0);
                        desenho.rotaciona(rh, ry, rb);
                        desenho.translada(desenho.getCentrox(), desenho.getCentroy(), 0);
                        break;
                    case KeyEvent.VK_Q:
                        rh = cX.isSelected() ? -0.1 : 0;
                        rb = cY.isSelected() ? -0.1 : 0;
                        ry = cZ.isSelected() ? -0.1 : 0;
                        desenho.translada(-desenho.getCentrox(), -desenho.getCentroy(), 0);
                        desenho.rotaciona(rh, ry, rb);
                        desenho.translada(desenho.getCentrox(), desenho.getCentroy(), 0);
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
                repaint();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    private void inicializa() {
        setBackground(Color.black);
        setForeground(Color.white);
        cX = new JCheckBox();
        cY = new JCheckBox();
        cZ = new JCheckBox();
        bSair = new JButton();
        bSair.setText("Sair");
        cX.setText("X");
        cY.setText("Y");
        cZ.setText("Z");
        cX.setFocusable(false);
        cY.setFocusable(false);
        cZ.setFocusable(false);
        bSair.setFocusable(false);
        bSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tela.dispose();
            }
        });
        GroupLayout layout = new GroupLayout(tela.getContentPane());
        tela.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(363, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(cX, GroupLayout.Alignment.TRAILING)
                                        .addComponent(cY, GroupLayout.Alignment.TRAILING)
                                        .addComponent(cZ, GroupLayout.Alignment.TRAILING)
                                        .addComponent(bSair, GroupLayout.Alignment.TRAILING))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(cX)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cY)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cZ)
                                .addComponent(bSair)
                                .addContainerGap(202, Short.MAX_VALUE)));
        desenho.setMundo(0, 0, 0, 20, 20, 20);
        desenho.setViewPort(0, 0, 1, 1);
        desenho.cubo();
    }

    @Override
    public void paint(Graphics g) {
        Dimension dim = this.getSize();
        desenho.setDimension(dim);
        desenho.desenha(g);
    }
}
