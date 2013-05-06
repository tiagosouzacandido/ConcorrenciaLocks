/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package concorrencialocks;

/**
 *
 * @author casa
 */
public class ConcorrenciaLocks {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Malha malha = new Malha();
        
        Agente preguicoso = new Agente(0, malha, malha.getNodo(0), "Agente Preguiçoso",200);
        Agente ponderado = new Agente(1, malha, malha.getNodo(0), "Agente Ponderado",200);
        Agente guloso = new Agente(2, malha, malha.getNodo(0), "Agente Guloso",200);
        
        preguicoso.start();
        ponderado.start();
        guloso.start();
        
    }
}
