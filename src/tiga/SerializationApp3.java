/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiga;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author idzni
 */
public class SerializationApp3 {

    public static void main(String[] args) {
        SerializationDemo demo = new SerializationDemo();
        List<Participant> participants = new ArrayList<Participant>();
        Scanner input = new Scanner(System.in);
        String nama1, nim1, jawab, asal1, kelas1 = "";
        String crnim = "";
        boolean ada=true;
        do {
            System.out.println("pilih salah satu : insert, update, delete, exit");
            jawab = input.next();
            if (jawab.equalsIgnoreCase("insert")) {
                System.out.println("");
                System.out.println("masukkan nama");
                nama1 = input.next();
                System.out.println("masukkan nim");
                nim1 = input.next();
                System.out.println("masukkan asal");
                asal1 = input.next();
                System.out.println("masukkan kelas");
                kelas1 = input.next();
                Participant baru=new Participant(nama1, nim1, asal1, kelas1);
                participants.add(baru);
                System.out.println("Tambah " + baru.toString());
                System.out.println("");
            } else if (jawab.equalsIgnoreCase("update")) {
                System.out.println("");
                System.out.println("masukkan nim");
                crnim = input.next();
                for (Participant i : participants) {
                    System.out.println(i.getNim());
                    if (i.getNim().equalsIgnoreCase(crnim)) {
                        System.out.println("data " + crnim);
                        System.out.println("nama : " + i.getNama());
                        System.out.println("nim : " + i.getNim());
                        System.out.println("asal :" + i.getAsal());
                        System.out.println("kelas :" + i.getKelas());
                        System.out.println("");
                        System.out.println("update nama");
                        nama1 = input.next();
                        System.out.println("update asal");
                        asal1 = input.next();
                        System.out.println("update kelas");
                        kelas1 = input.next();
                        i.setNama(nama1);
                        i.setAsal(asal1);
                        i.setKelas(kelas1);
                        System.out.println("Update " +crnim+" menjadi "+ i.toString());
                        break;
                    }else {ada=false;}
                }
                if (!ada) {
                        System.out.println(crnim+" tidak ditemukan"); 
                    }
                System.out.println("");
            } else if (jawab.equalsIgnoreCase("delete")) {
                System.out.println("");
                System.out.println("masukkan nim");
                crnim = input.next();
                for (Participant i : participants) {
                    if (i.getNim().equalsIgnoreCase(crnim)) {
                        participants.remove(i);
                        System.out.println("participant "+i+" telah dihapus");
                        //System.out.println("Participants : " + participants.toString());
                        System.out.println("");
                        break;
                    }else {ada=false;}

                }
                if (!ada) {
                        System.out.println(crnim+" tidak ditemukan"); 
                    }
                System.out.println("");
            }

        } while (!jawab.equalsIgnoreCase("exit"));
        System.out.println("print objek?");
        jawab=input.next();
        if (jawab.equalsIgnoreCase("ya")) {
            System.out.println("Participants : " + participants.toString());
        }
        System.out.println("save data?");
        jawab=input.next();
        if (jawab.equalsIgnoreCase("ya")) {
            demo.serialize(participants, "participantData.ser");
            System.out.println("silahkan buka file participantData.ser :)");
            
        }

//                          UNTUK NO 2
//        participants.add(new Participant("Dee", "aja", 22));
//        participants.add(new Participant("Ami", "Fahmi", 22));
//        participants.add(new Participant("Haya", "Hayati", 22));
//        participants.add(new Participant("Aya", "Hayati", 22));
        
 //       demo.serialize(participants, "participantData.ser");
  //      System.out.println("Participants : " + participants.toString());
 //       System.out.println("serialisasi selesai");
  //      System.out.println("deserialisasi objek...");
 //       List<Participant> newList = demo.deserialize("participantData.ser");
 //       System.out.println("New List: " + newList);

    }
}
