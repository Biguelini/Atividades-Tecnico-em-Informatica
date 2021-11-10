/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author 2info2021
 */
public class Game extends JFrame {

    public Game() {
        int altura = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        int largura = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        setSize(largura, altura);
        add(new Labirinto(largura, altura));
        setResizable(false);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Game();
    }
}
