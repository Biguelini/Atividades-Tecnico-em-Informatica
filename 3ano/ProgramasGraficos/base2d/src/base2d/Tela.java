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
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Tela extends JFrame {

    public Tela() {
        setBackground(Color.black);
        setForeground(Color.white);
        setUndecorated(true);
        Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
        Dimension scrSize = toolkit.getScreenSize();
        setSize(scrSize.width, scrSize.height);
        add(new Painel(scrSize.width, scrSize.height, this));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Tela();
    }

}
