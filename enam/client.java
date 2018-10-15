/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enam;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
/**
 *
 * @author idzni
 */
public class client extends Thread{
    public static final int SERVICE_PORT = 13;
    String hostname = "localhost";
    InputStream in ;
    BufferedReader bf ;
    @Override
    public void run(){
        try{
            Socket client = new Socket(hostname, SERVICE_PORT);
            bf = new BufferedReader(new InputStreamReader(client.getInputStream()));
            System.out.println(bf.readLine());
            Thread.sleep(5000);
            Socket client2 = new Socket(hostname, SERVICE_PORT);
            bf = new BufferedReader(new InputStreamReader(client2.getInputStream()));
            System.out.println(bf.readLine());
            Thread.sleep(5000);
            Socket client3 = new Socket(hostname, SERVICE_PORT);
            bf = new BufferedReader(new InputStreamReader(client3.getInputStream()));
            System.out.println(bf.readLine());
            Thread.sleep(5000);
            Socket client4 = new Socket(hostname, SERVICE_PORT);
            bf = new BufferedReader(new InputStreamReader(client4.getInputStream()));
            System.out.println(bf.readLine());
            Thread.sleep(5000);
            Socket client5 = new Socket(hostname, SERVICE_PORT);
            bf = new BufferedReader(new InputStreamReader(client5.getInputStream()));
            System.out.println(bf.readLine());
            Thread.sleep(5000);
            client.close();
            client2.close();
            client3.close();
            client4.close();
            client5.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        Thread t1 = new client();
        t1.start();
    }

}
