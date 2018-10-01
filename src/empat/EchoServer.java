/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empat;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.List;

/**
 *
 * @author idzni
 */
public class EchoServer {
  public static final int SERVICE_PORT=7;
  public static final int BUFSIZE=4096;
  private DatagramSocket soket;
  
  public EchoServer(){
      try {
          soket=new DatagramSocket(SERVICE_PORT);
          System.out.println("server active on port "+soket.getLocalPort());
      } catch (Exception e) {
          System.out.println("unable to bind port");
      }
  }
  
  public void serviceClients(){
  byte[] buffer=new byte[BUFSIZE];
  //SerializationDemo demo = new SerializationDemo();
  for(;;){
      try {
          DatagramPacket paket=new DatagramPacket(buffer, BUFSIZE);
          soket.receive(paket);
          System.out.println("paket received from "
                  +paket.getAddress()+";"+paket.getPort()+" of length "+paket.getLength()
          );
          String message=new String(paket.getData(),0, paket.getLength());
          System.out.println(message);
          //List<Participant> newList = demo.deserialize(message);
          try (FileOutputStream f=new FileOutputStream("participantData2.ser")){
              for (int i = 0; i < message.length(); i++) {
                  f.write(message.charAt(i));
              }
          } catch (Exception e) {
          }
         // demo.serialize(newList, "participantData2.ser");
         System.out.println("silahkan buka file participantData2.ser :)");
         
          
          
          soket.send(paket);
      } catch (Exception e) {
          System.out.println("error: "+e);
      }
  }
  }
  
  public static void main(String args[]){
  EchoServer server=new EchoServer();
  server.serviceClients();
  }
}
