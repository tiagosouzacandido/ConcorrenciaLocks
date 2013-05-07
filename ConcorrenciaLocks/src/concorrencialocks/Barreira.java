/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package concorrencialocks;

/**
 *
 * @author casa
 */
public class Barreira {
    private int threads, esperando;

    public Barreira(int num) {
        threads = num;
        esperando = 0;
    }

    public synchronized void Chegou(){
        esperando++;
        if (threads != esperando) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        } else {
            notifyAll();
            esperando = 0;
        }
    }
}
