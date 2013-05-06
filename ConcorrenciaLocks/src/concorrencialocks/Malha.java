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
        {1,2},{3,7},{4,5},{6,7},{7,8},{8,9},{0,0},{10,11},
        {11,12},{12,12},{0,0},{13,14},{14,14},{0,0},{0,0}
    };
    private static int[][] recursos = {
        {0,0,0},{3,7,10},{5,14,20},{3,7,10},{5,15,20},{11,23,30},{11,23,30},{5,13,20},
        {11,23,30},{16,27,40},{3,7,10},{5,12,20},{11,22,30},{3,7,10},{5,15,20}
    };
    
    
    public Malha(){ 
        nodos = new Nodo[15];
        for(int i=0;i<15;i++){
            nodos[i]= new Nodo(caminhos[i], i, recursos[i]);
        }      
    }
    
    public Nodo getNodo(int numNodo){
        return nodos[numNodo];
    }
}
