package Exemplo01;

import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.time.LocalDateTime;

class Cavalo implements Runnable {
    
    //Vars
    int min = 0, max = 10,distancia = 0,DistanciaPercorrida = 0;  
    String nome;


    public Cavalo(String NomeDoCavalo) 
    {        
        
        this.nome = NomeDoCavalo;   
        
    }

    @Override
    public void run() 
    {
        try 
        {  
            Random randomnum = new Random();
            
            int NumGetted = randomnum.nextInt(10);
            
            while (DistanciaPercorrida < 1000) 
            {
                
               DistanciaPercorrida += NumGetted;        
               
            }
            if(DistanciaPercorrida >= 1000) 
            {            
                
                System.out.println(nome + " finalizou a corrida!");   
                
            }
            Thread.sleep(1);  
            
        } catch (InterruptedException ex) 
        {            
            
            ex.printStackTrace();  
            
        }
    }
}

public class Exemplo1 {

    public static void main(String[] args) {
        
        Cavalo Horse1;
        Horse1 = new Cavalo("Cavalo 001");        
        Cavalo Horse2;
        Horse2 = new Cavalo("Cavalo 002");
        Cavalo Horse3; 
        Horse3 = new Cavalo("Cavalo 003");

        ExecutorService threadExecutorCL = Executors.newFixedThreadPool(3);
       
        threadExecutorCL.execute(Horse1);
        threadExecutorCL.execute(Horse2);
        threadExecutorCL.execute(Horse3);       
        
        //Terminate Threads
        threadExecutorCL.shutdown();

    }
}
