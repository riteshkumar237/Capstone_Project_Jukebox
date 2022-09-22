package com.niit.jdp.service;

import com.niit.jdp.Main;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SongPlayerService {

    public void player(String songPath) {

        Scanner scanner = new Scanner(System.in);

        File songFile = new File(songPath);


        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(songFile);

            Clip clip = AudioSystem.getClip();

            clip.open(audioInputStream);

            String response = "";

            while (!response.equals("Q")) {
                System.out.println("P = play, T= Pause, S=Stop, L=Loop, R = Reset, N = NextSong, O = previousSong, Q = Quit, E = Exit, M = MAIN MENU");
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
                    case ("l"): {
                        clip.start();
                        clip.loop(Clip.LOOP_CONTINUOUSLY);
                    }

                    case ("r"):
                        clip.setMicrosecondPosition(0);
                        break;

                    case ("q"):
                        clip.close();
                        break;

                    case ("n"):
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
