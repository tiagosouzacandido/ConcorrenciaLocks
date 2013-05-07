/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package concorrencialocks;

/**
 *
 * @author Tiago
 */
public class Agente extends Thread{
    
    //static ThreadLocal moedasColetadas = new ThreadLocal();
    private int contador = 0;
    private int tipo;
    private int deadline;
    private int deadlineRestando;
    private Nodo nodo;
    private Malha malha;
    private Barreira barreira;
    //public static boolean running = true;
    
    public Agente(int tipo, Malha malha, Nodo nodo, Barreira barreira , String nome,int deadline) {
        this.setName(nome);
        this.nodo = nodo;
        this.malha = malha;
        this.tipo = tipo;
        this.deadline = deadline;
        this.barreira = barreira;
        this.deadlineRestando=this.deadline;
    }
    
    @Override
    public void run() {
        while (deadline <= 1000) {
            try {
                Nodo nodo1 = malha.getNodo(nodo.getCaminho(0));
                Nodo nodo2 = malha.getNodo(nodo.getCaminho(1));
                if((!nodo1.getLock().isLocked()) && (!nodo2.getLock().isLocked())){
                    nodo=this.getMelhorNodo(nodo1, nodo2);
                }else if(!nodo1.getLock().isLocked()){
                    nodo = nodo1;
                }else if(!nodo2.getLock().isLocked()){
                    nodo = nodo2;
                }else{
                    nodo=this.getMelhorNodo(nodo1, nodo2);
                }
                System.out.println(getName() + " vai para o nodo " + nodo.getNumeroNodo() + ".");
                Thread.sleep(100);
                deadlineRestando -= 100;
                int coletadas = nodo.consomeRecursos(this.tipo);
                deadlineRestando -= coletadas;
                contador += coletadas;
                System.out.println(getName() + " consumiu " + contador + " recursos.");  
                if(nodo.getNumeroNodo() == 0 || deadlineRestando<=100){
                    nodo = malha.getNodo(0);
                    System.out.println(" ------ " + getName() + " chegou no nodo " + nodo.getNumeroNodo() + ". ----- ");
                    contador = 0;
                    deadline += 100;
                    deadlineRestando = deadline;
                    System.out.println("Deadline do " + getName() + " foi para " + deadline + ".");
                    barreira.Chegou();
                }
            } catch (InterruptedException e) {
            }
        }

        System.out.println(getName() + " terminou.");
    }
    
    private Nodo getMelhorNodo(Nodo nodo1, Nodo nodo2){
        Nodo melhorNodo;
        if (tipo == 0){
            if(nodo1.getQuantRecursos(tipo)<=nodo2.getQuantRecursos(tipo)){
                melhorNodo=nodo1;
            }else{
                melhorNodo=nodo2;
            }
        }else if(tipo == 2){
            if(nodo1.getQuantRecursos(tipo)>=nodo2.getQuantRecursos(tipo)){
                melhorNodo=nodo1;
            }else{
                melhorNodo=nodo2;
            }
        }else{
            melhorNodo=nodo1;
        }    
        return melhorNodo;
    }
}
