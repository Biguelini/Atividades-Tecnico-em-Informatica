/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

/**
 *
 * @author 2info2021
 */
import javax.swing.JFrame;

public class Tenis extends JFrame {

    public Tenis() {
        setTitle("Tenis v1.0");
        setSize(1280, 720);
        add(new Campo(1280, 720));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Tenis();
    }
}
