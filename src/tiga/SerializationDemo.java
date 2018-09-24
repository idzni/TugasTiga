/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiga;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 *
 * @author idzni
 */
public class SerializationDemo {
    public void serialize(List<Participant> pList, String fileName) {
        try {
            ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(fileName));
            out.writeObject(pList);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public List<Participant> deserialize(String fileName){
        List<Participant> pList=null;
        try {
            ObjectInputStream in=new ObjectInputStream(new FileInputStream(fileName));
            pList=(List<Participant>)in.readObject();
        } catch (Exception e) {
            System.out.println(e);
        }
        return pList;
    }
    
}
