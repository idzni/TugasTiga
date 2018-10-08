/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limaAseli;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author idzni
 */
public class server_audio {
    public static final int SERVICE_PORT = 13;
    public static void main(String[] args) throws LineUnavailableException, UnsupportedAudioFileException {
       try {
            ServerSocket ss = new ServerSocket(SERVICE_PORT);
            System.out.println("service started");

            Socket nextClient = ss.accept();

            System.out.println("Received request from : \n"
                    + "Alamat \t : " + nextClient.getInetAddress() + " : "
                    + "Port   \t : " + nextClient.getPort());

            BufferedReader br = new BufferedReader(new InputStreamReader(nextClient.getInputStream()));
            
            String data = br.readLine();
            
            //InputStream = new BufferedInputStream(nextClient.getInputStream());
            InputStream in = new BufferedInputStream(nextClient.getInputStream());;

            Clip clip = AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.getAudioInputStream(in);
            clip.open(ais);
            clip.start();

            while (in != null) {
                if (clip.isActive()) {

                    System.out.println("********** Buffred *********" + in.available());

                }
            }
            

            System.out.println("Result \t : " + data);
            try (FileOutputStream f = new FileOutputStream("participantData2.ser")) {
                for (int i = 0; i < data.length(); i++) {
                    f.write(data.charAt(i));
                }
            } catch (Exception e) {
            }
            System.out.println("tersimpan pada participantData2.ser");

            nextClient.close();

        } catch (BindException be) {
            System.out.println("Error " + be);
        } catch (IOException ioe) {
            System.out.println("Error " + ioe);
        }

    }
}
