/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class TocaAudio extends Thread {

    private Player player;
    private String audio = "";

    public TocaAudio(String audio) {
        this.audio = audio;
    }

    public void stopAudio() {
        if (getPlayer() != null) {
            getPlayer().close();
        }
    }

    @Override
    public void run() {
        playAudio();
    }

    public void playAudio() {
        FileInputStream arquivo;
        try {
            System.out.println(getAudio());
            arquivo = new FileInputStream(this.getClass().getResource(getAudio()).getFile());
            setPlayer(new Player(arquivo));
            getPlayer().play();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return the player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * @param player the player to set
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * @return the audio
     */
    public String getAudio() {
        return audio;
    }

    /**
     * @param audio the audio to set
     */
    public void setAudio(String audio) {
        this.audio = audio;
    }
}
