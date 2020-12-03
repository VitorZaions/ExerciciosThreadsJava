package Exemplo01;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.time.LocalDateTime;

class T1 implements Runnable {   
    
    //Declare ID Thread
    int ID;

    public T1(int id) {        
        this.ID = id;        
    }

    @Override
    public void run() {        
        try {            
            while (true) {
                
                System.out.println("Thread " + ID + ": executando.");
                
                Thread.sleep(100);
            }
        } catch (InterruptedException ex) {
            
            ex.printStackTrace(); 
            
        }
    }
}

public class Exemplo1 {
   
        public static void main(String[] args) {
            
        System.out.println("Iniciando as threads...");    
        
        ExecutorService executerT1Thread = Executors.newFixedThreadPool(1); 
        //Instance
        executerT1Thread.submit( new T1(0) );  
        
        Thread mythreads[] = new Thread[5];
        for (int j = 0; j < 5; j++) {
            mythreads[j] = new Thread(new Threads(j));
            mythreads[j].start();
        }
        
        ExecutorService threadExecutorT1 = Executors.newFixedThreadPool(100);
        
        for (int j = 0; j < 5; j++) {           
            try {
                
                mythreads[j].join();
                
            } catch (InterruptedException e) {
                
                e.printStackTrace();
                
            }
        }
        
        //Shutdown Executors        
        threadExecutorT1.shutdown();          
        executerT1Thread.shutdown();       
        
        //System.out.println("Iniciando as threads...");    
     //   System.out.println("Iniciando as threads...");    
    }
  
}
