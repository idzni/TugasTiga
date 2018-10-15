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
public class satu extends Thread {

    int tn;
    int[] satu = {6, 9, 1, 2, 3, 5};
    int[] dua = {7, 11, 6, 4, 3, 1};
    int[] tiga = {5, 4, 3, 2, 1, 12};

    public satu(int num) {
        tn = num;
    }

    public static void main(String[] args) {

        Thread t1 = new satu(1);
        Thread t2 = new satu(2);
        Thread t3 = new satu(3);
        Thread t4 = new satu(4);
        Thread t5 = new satu(5);
        Thread t6 = new satu(6);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();

    }

    public void run() {
        int i = tn - 1;

        int hasil = satu[i] + dua[i] + tiga[i];
        System.out.println("thread " + (i + 1) + "=" + satu[i] + "+" + dua[i] + "+" + tiga[i] + "=" + hasil);

    }
}
