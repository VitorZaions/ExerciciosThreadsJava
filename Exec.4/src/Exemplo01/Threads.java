/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exemplo01;

/**
 *
 * @author Vítor
 */
public class Threads implements Runnable {  
    private int id;    
    
    public Threads(int id) {
        this.id = id;
    }
    
    @Override
    public void run() {                
        try {            
            Thread.sleep(500);
            System.out.println("A Thread " + this.id + " executou.");
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }    
}