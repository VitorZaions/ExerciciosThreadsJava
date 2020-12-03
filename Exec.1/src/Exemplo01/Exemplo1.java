package Exemplo01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exemplo1 {

    public static void main(String[] args) {
        
        System.out.println("Iniciando as threads...");
       
        PrintTask[] meuArray = new PrintTask[100];
        
        for (int i = 0; i < 100; i++) {
             meuArray[i] = new PrintTask("T" + i);
        }
        
        ExecutorService threadExecutor = Executors.newFixedThreadPool(3);
        
        for (int i = 0; i < 100; i++) {
             threadExecutor.execute(meuArray[i]); // Inicia thread 3
        }            
    }    
}
