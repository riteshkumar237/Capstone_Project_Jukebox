package com.niit.jdp.service;

import com.niit.jdp.Main;
import com.niit.jdp.model.Playlist;
import com.niit.jdp.model.Song;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class SongPlayerService {

    int songIndex;

    public void play(List<Song> songsList) {

        Playlist playlist = new Playlist();

        for (int i = 0; i < playlist.getSongList().size(); i++) {
            songIndex = i;
            player(songsList.get(i).getSongPath());
        }

    }


    public void player(String songPath) {

        Scanner scanner = new Scanner(System.in);

        File songFile = new File(songPath);


        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(songFile);

            Clip clip = AudioSystem.getClip();

            clip.open(audioInputStream);

            String response = "";

            while (!response.equals("Q")) {
                System.out.println("p = play, t= Pause, s=Stop, r = Reset, q = Quit, e = Exit, m = MAIN MENU");
                System.out.print("Enter your choice: ");

                response = scanner.next();


                switch (response) {
                    case ("p"): {
                        clip.start();
                        break;
                    }
                    case ("t"): {
                        clip.stop();
                        break;
                    }
                    case ("s"): {
                        clip.setMicrosecondPosition(0);
                        clip.stop();
                        break;
                    }

                    case ("r"):
                        clip.setMicrosecondPosition(0);
                        break;

                    case ("q"):
                        clip.close();
                        break;

                    case ("m"):
                        String[] arg = new String[0];
                        Main.main(arg);
                        break;
                    case ("e"):
                        System.exit(0);
                        break;

                    default:
                        System.err.println("PLEASE SELECT THE CORRECT OPTION");
                }
            }
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException exception) {
            System.err.println(exception.getMessage());
            exception.printStackTrace();
        }
    }
}
