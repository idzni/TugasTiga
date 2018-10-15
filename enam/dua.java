/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enam;

/**
 *
 * @author idzni
 */
public class dua extends Thread {
 
    int tn;
    

    public dua(int num) {
        tn = num;

    }

    public dua() {
        
    }
    

    public static void main(String[] args) {
        
        Thread t1 = new dua(1);
        Thread t2 = new dua(2);
        Thread t3 = new dua(3);
        Thread t4 = new dua(4);
        Thread t5 = new dua(5);
        Thread t6 = new dua(6);
        Thread t7 = new dua(7);
        Thread t8 = new dua(8);
        Thread t9 = new dua(9);
        Thread t10 = new dua(10);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();

    }

    @Override
    public void run() {
        int count=0;
        int i = tn;
        dua y = new dua();
        y.dokter(i);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {

        }
        if (i < 6) {
            y.perawat1(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {

            }
        } else {
            y.perawat2(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {

            }
        }

        y.kasir(i);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {

        }

    }

    public void dokter(int i) {
        System.out.println("pasien " + i + " diperiksa dokter");
    }

    public void perawat1(int i) {
        System.out.println("pasien " + i + " diperiksa perawat 1");
    }

    public void perawat2(int i) {
        System.out.println("pasien " + i + " diperiksa perawat 2");
    }

    public void kasir(int i) {
        System.out.println("pasien " + i + " membayar di kasir");
    }
}
