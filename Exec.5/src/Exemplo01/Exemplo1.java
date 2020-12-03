package Exemplo01;

import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.time.LocalDateTime;

class ThreadPar extends Thread {
    int min = 1, max = 15;

    @Override
    public void run() {
        try 
        {
            
            //Get Random Num
            Random GetRandomNumber = new Random();
            int RandomGetted = GetRandomNumber.nextInt((max - min) + 1) + min;
            
            
            if ((RandomGetted % 2) == 0) 
            {
                
                synchronized (this) {     
                    
                    System.out.println("Número par obtido : " + RandomGetted + ".");  
                    
                    wait(1999);   
                    
                }
                
            }
            
        } catch (InterruptedException ex) {
            
            ex.printStackTrace();            
        }
        
    }
    
}

class ThreadImpar implements Runnable {
    int min = 1, max = 15;

    @Override
    public void run() {
        try 
        {
            
            Random GetRandomNumber = new Random();
            
            int RandomGetted = GetRandomNumber.nextInt((max - min) + 1) + min;
            
            if ((RandomGetted % 2) != 0) 
            {
                
                synchronized (this) {
                    
                    System.out.println("Número Impar obtido : " + RandomGetted + ".");
                    
                    wait(3000);
                    
                }
            }
        } catch (InterruptedException ex) {
            
            ex.printStackTrace();
            
        }
    }
}

class TimerClass {
    // Get Time Hour
    String Time() {        
        // Get Time
        Calendar DateTimeH;
        DateTimeH = Calendar.getInstance();
        ///////////////////
        String time = DateTimeH.get(Calendar.HOUR_OF_DAY) + ":" + DateTimeH.get(Calendar.MINUTE) + ":" + DateTimeH.get(Calendar.SECOND);
        return time;
        
    }
}

class ThreadDivFive extends Thread {
    int min = 0, max = 50;

    @Override
    public void run() {
        try 
        {
            Random GetRandomNumber = new Random();
            
            int RandomGetted = GetRandomNumber.nextInt((max - min) + 1) + min;
            
            if ((RandomGetted % 5) == 0) 
            {
                
                synchronized (this) {
                    
                    System.out.println("Número Divisível por 5 : " + RandomGetted + ".");
                    
                    wait(5000);
                    
                }
                
            }
            
        } catch (InterruptedException ex) {
            
            ex.printStackTrace();
            
        }
        
    }
    
}

public class Exemplo1 {

    public static void main(String[] args) {
        for (int i = 0; i < 15; i++) 
        {
            
            //Create Threads 
            
            Thread ThreadImpar = new Thread(new ThreadImpar());
            
            Thread ThreadPar = new Thread(new ThreadPar());
            
            Thread ThreadDivFive = new Thread(new ThreadDivFive());
            

            ThreadImpar.start();
            ThreadPar.start();
            ThreadDivFive.start();

            try 
            {
                ThreadImpar.join();
                ThreadPar.join();
                ThreadDivFive.join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        TimerClass Time = new TimerClass();
        
        System.out.println(Time.Time());
    }
}
