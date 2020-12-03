package Exemplo01;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.time.LocalDateTime;

public class Exemplo1 {
   
    public void Matriz() {
     
        Exemplo1 MatrizSolver = new Exemplo1();
      
        int TAM = MatrizSolver.GetRandomNumber(); 
        
        int Matriz[][] = new int[TAM][TAM];
        
        int ValueGE;

        System.out.println("Tamanho da Matriz:\n" + TAM + " x " + TAM);

        for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM; j++) {
               
                ValueGE = MatrizSolver.GetRandomNumber();
              
                Matriz[i][j] = ValueGE;
              
                System.out.print(Matriz[i][j] + " ");
                
            }
            System.out.println();
        }

        for (int i = 0; i < TAM; i++) {
            int soma = 0;
            
            for (int j = 0; j < TAM; j++) {
                
                soma += Matriz[i][j];
                
            }
            System.out.print(soma + "\n");
        }  
    }   
    
    public boolean Thread(Runnable Matriz) {
        try {
            Thread Thread0 = new Thread(Matriz);
            
            Thread0.start();    
            
                try {
                    
                    Thread.sleep(1000);
                    
                } catch (InterruptedException e) {
                    
                    e.printStackTrace();
                }            
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    
     public int GetRandomNumber() {         
         // Set max and min
        int max = 5, min = 3;
         Random random = new Random();
         
        // Get Number And Return
        int RandoNumber = random.nextInt((max - min) + 1) + min;
        
        return RandoNumber;
    }  
    
    
    
    public static void main(String[] args) {
        // Instance
        Exemplo1 MatrizSolverT = new Exemplo1();        
        MatrizSolverT.Thread(MatrizSolverT::Matriz);        
    }    
}
