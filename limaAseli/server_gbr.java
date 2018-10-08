/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limaAseli;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author idzni
 */
public class server_gbr {

    public static final int SERVICE_PORT = 13;

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(SERVICE_PORT);
            System.out.println("service started");
            // for (;;) {
            Socket nextClient = ss.accept();

            System.out.println("Received request from : \n"
                    + "Alamat \t : " + nextClient.getInetAddress() + " : "
                    + "Port   \t : " + nextClient.getPort());

            BufferedImage img = ImageIO.read(ImageIO.createImageInputStream(nextClient.getInputStream()));
            JFrame frame = new JFrame();
            JLabel label = new JLabel(new ImageIcon(img));
            frame.getContentPane().add(label, BorderLayout.CENTER);
            frame.pack();
            frame.setVisible(true);
            ImageIO.write(img, "png", new File("output.png"));
            nextClient.close();
            //}
        } catch (BindException be) {
            System.out.println("Error " + be);
        } catch (IOException ioe) {
            System.out.println("Error " + ioe);
        }
    }
}
