/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiga;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author idzni
 */
public class ParticipantSer implements Serializable{
  private String firstName;
  private String lastName;
  private int age;
  
  public ParticipantSer(String firstName, String lastName, int age){
    this.firstName=firstName;
    this.lastName=lastName;
    this.age=age;
  }
  
  public void printData(){
      System.out.println("Nama\t: "+firstName+" "+lastName);
      System.out.println("Usia\t: "+age);
  }
  
  public void saveObject (ParticipantSer Obj){
      try {
          FileOutputStream fos=new FileOutputStream("data.ser");
          ObjectOutputStream oos=new ObjectOutputStream(fos);
          oos.writeObject(Obj);
          oos.flush();
          oos.close();
      } catch (Exception ex) {
          System.out.println(ex);
      }    
  }
  
  public void readObject(ParticipantSer Obj){
      try {
          FileInputStream fis=new FileInputStream("data.ser");
          ObjectInputStream ois=new ObjectInputStream(fis);
          Obj=(ParticipantSer)ois.readObject();
          Obj.printData();
          fis.close();
      } catch (Exception e) {
          System.out.println(e);
          System.exit(1);
      }
  }
  
    public static void main(String[] args) {
        ParticipantSer is=new ParticipantSer("Dee", "aja", 22);
        is.saveObject(is);
        is.readObject(is);
    }
}
