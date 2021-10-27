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
import javax.swing.JFrame;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class Snake extends JFrame {

    public Snake() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        setTitle("Snake v1.0 - By Biguelini");
        setSize(1000, 733);
        add(new Campo(1000, 733));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        Snake snake = new Snake();
    }
}
