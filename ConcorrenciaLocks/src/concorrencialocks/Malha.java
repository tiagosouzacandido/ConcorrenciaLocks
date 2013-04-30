/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package concorrencialocks;

/**
 *
 * @author Tiago
 */
public class Malha {
    Nodo[] nodos;
    private static int[][] caminhos = {
            {2,15},{1,3,4,5},{2,9},{2,9,10},{2,6},{7,8},{6},{6},
            {3,4,15,18},{4,12},{12,14,17},{10,11,13},{12},{11,16},
            {1,9},{14,17,18,20},{11,16},{9,16,19},{18,20},{16,19}
        };
    
    public Malha(){ 
        nodos = new Nodo[20];
        for(int i=0;i<20;i++){
            nodos[i]= new Nodo(caminhos[i], i+1);
        }      
    }
    
    public Nodo getPote(int numPote){
        return nodos[numPote-1];
    }
}
