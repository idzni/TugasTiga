/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enam;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
/**
 *
 * @author idzni
 */
public class server extends Thread{
    public static final int SERVICE_PORT = 13;
    OutputStream out;
    InputStream in;
    PrintStream pout;
    @Override
    public void run(){
        try{
            ServerSocket server = new ServerSocket(SERVICE_PORT);
            System.out.println("Server is getting started");
            int i=0;
                while(true){
                    Socket client = server.accept();
                    System.out.println("Received Request from "+client.getInetAddress()+" : "+ client.getPort());
                    out = client.getOutputStream();
                    pout = new PrintStream(out);
                    pout.print("Selamat datang, anda visitor ke "+(i+1));
                    out.flush();
                    pout.close();
                    client.close();
                    i++;
                }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        Thread t1 = new server();
        t1.start();
    }

}
