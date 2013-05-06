/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package concorrencialocks;

import java.util.concurrent.locks.*;
import java.util.Random;

/**
 *
 * @author Tiago
 */
public class Nodo {

    private int numeroNodo;
    private ReentrantLock lock = new ReentrantLock();
    private int[] caminho;
    private int[] recursos;

    public Nodo(int[] caminho, int numNodo, int[] recursos) {
        this.caminho = caminho;
        this.numeroNodo = numNodo;
        this.recursos = recursos;
    }

    public int getCaminho() {
        Random random = new Random();
        int posicao = random.nextInt(caminho.length);
        int numNodo = caminho[posicao];
        return numNodo;
    }
    
    public int getCaminho(int index){
        return caminho[index];
    }
    
    public int getQuantRecursos(int index){
        return recursos[index];
    }

    public int consomeRecursos(int tipoAgente) throws InterruptedException {
        lock.lock();
        try {
            int coletadas = 0;
            while (recursos[tipoAgente] > 0) {
                recursos[tipoAgente]--;
                coletadas++;
                Thread.sleep(1);
            }
            return coletadas;
        } finally {
            lock.unlock();
            
        }
    }
    
    public ReentrantLock getLock(){
        return this.lock;
    }
    
    public int getNumeroNodo(){
        return this.numeroNodo;
    }
}
