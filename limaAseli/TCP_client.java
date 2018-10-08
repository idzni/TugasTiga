/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limaAseli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import tiga.Participant;
import tiga.SerializationDemo;

/**
 *
 * @author idzni
 */
public class TCP_client {

    public static final int SERVICE_PORT = 13;

    public static void main(String[] args) {
        try {
            //  for (;;) {
            String hostname = "localhost";
            Socket daytime = new Socket(hostname, SERVICE_PORT); //Membuat Koneksi
            System.out.println("COnnection Established");

            daytime.setSoTimeout(2000);


            SerializationDemo demo = new SerializationDemo();

            Scanner input = new Scanner(System.in);
            String nama1, nim1, jawab, asal1, kelas1 = "";
           

           
               
                    System.out.println("");
                    System.out.println("masukkan nama");
                    nama1 = input.next();
                    System.out.println("masukkan nim");
                    nim1 = input.next();
                    System.out.println("masukkan asal");
                    asal1 = input.next();
                    System.out.println("masukkan kelas");
                    kelas1 = input.next();
                    Participant baru = new Participant(nama1, nim1, asal1, kelas1);
                    //participants.add(baru);
                    System.out.println("Tambah " + baru.toString());
                    System.out.println("");
               
            
                System.out.println("Mahasiswa : " + baru.toString());
            
    
           
                demo.serialize(baru, "participantData.ser");
                System.out.println("silahkan buka file participantData.ser :)");
            

            //proses nulis
            OutputStream os = daytime.getOutputStream();
            PrintStream ps = new PrintStream(os);
            //nulis ke server
            ps.print(baru);

            os.flush();
            os.close();
            daytime.close();
            // }
        } catch (IOException ioe) {
            System.out.println("Error " + ioe);
        }
    }

}
