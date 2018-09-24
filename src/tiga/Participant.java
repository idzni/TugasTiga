/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiga;


import java.io.Serializable;


/**
 *
 * @author idzni
 */
public class Participant implements Serializable{

  private String nama, nim, asal, kelas;
  
  public Participant(String nama, String nim, String asal, String kelas){
    this.nama=nama;
    this.nim=nim;
    this.asal=asal;
    this.kelas=kelas;
  }
  public String getNama(){
  return nama;
  }
  
  public String getNim(){
  return nim;
  }
  
  public String getAsal(){
  return asal;
  }
  
  public String getKelas(){
  return kelas;
  }
  
  public void setKelas(String kelas){
  this.kelas=kelas;
  }
  
  public void setNama(String nama){
  this.nama=nama;
  }
  
  public void setNim(String nim){
  this.nim=nim;
  }
  public void setAsal(String asal){
  this.asal=asal;
  }
  
  public String toString(){
      return nama+" "+nim+" "+asal+" "+kelas;
  }
  
 
}
