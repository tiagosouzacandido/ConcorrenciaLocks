/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package concorrencialocks;

import java.util.concurrent.locks.*;

/**
 *
 * @author Tiago
 */
public class Nodo {
    
    private int numNodo;
    private Lock lock = new ReentrantLock();
    private int[] caminho;
    private int[] recursos;
    
    public Nodo(int[] array,int numNodo){
        this.caminho = array;
        this.numNodo=numNodo;
    }
}
