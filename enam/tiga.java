/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enam;

import java.io.IOException;

/**
 *
 * @author idzni
 */
public class tiga extends Thread{
  static boolean cek = true;
    int tn = 0;
    
    @Override
    public void run(){
       for(;;){
           if(cek){
             tn++;
             if(tn%2==0){
                 System.out.print(tn + " ");
             }
           }else{
               tn--;
               if(tn%2==1){
                   System.out.print(tn +" ");
               }
           }
           try{
               Thread.sleep(500);
           }catch(InterruptedException ie){
               
           }
       }
    }
    public static void main(String[] args) throws IOException {
        Thread t1 = new tiga();
        t1.start();
        System.out.println("press enter to suspend");
        System.in.read();
        t1.suspend();
        System.out.println("press enter to resume");
        System.in.read();
        t1.resume();
        cek = false;
        System.out.println("press enter to stop");
        System.in.read();
        t1.stop();
    }

}
