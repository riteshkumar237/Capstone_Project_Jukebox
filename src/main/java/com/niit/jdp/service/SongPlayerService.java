package com.niit.jdp.service;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SongPlayerService {

    public void player(String songPath) {

        File songFile = new File(songPath);

        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(songFile);

            Clip clip = AudioSystem.getClip();

            clip.open(audioInputStream);

            clip.loop(Clip.LOOP_CONTINUOUSLY);

            clip.start();

            long songDurationInMillisecond = clip.getMicrosecondLength();

            Thread.sleep(songDurationInMillisecond);

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException exception) {
            System.err.println(exception.getMessage());
            exception.printStackTrace();
        } catch (InterruptedException exception) {
            System.err.println("song thread was interrupted");
        }

    }


}
