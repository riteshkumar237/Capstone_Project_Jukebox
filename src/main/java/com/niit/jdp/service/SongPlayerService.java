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

            while (!response.equals("q")) {
                System.out.println("p = play, t= Pause, s=Stop, q = Quit, e = Exit, m = MAIN MENU");
                System.out.print("Enter your choice: ");

                response = scanner.next();


                switch (response) {
                    case ("p"):
                        clip.start();
                        break;

                    case ("t"):
                        clip.stop();
                        break;

                    case ("s"):
                        clip.setMicrosecondPosition(0);
                        clip.stop();
                        break;


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
