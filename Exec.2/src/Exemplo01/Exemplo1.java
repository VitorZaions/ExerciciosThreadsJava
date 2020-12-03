package Exemplo01;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exemplo1 {

    public static void main(String[] args) {
         
          String[] strArray3 = new String[5];
          strArray3[0] = "Notícia 1";
          strArray3[1] = "Notícia 2";
          strArray3[2] = "Notícia 3";
          strArray3[3] = "Notícia 4";
          strArray3[4] = "Notícia 5";
          
          int notices = 0;         
        
          Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                    for( ; ; ){
                    try {
                        System.out.println("Hora: " + LocalDateTime.now().getHour() + " : " + LocalDateTime.now().getMinute() +  " : " + LocalDateTime.now().getSecond()) ;      // 7
                        Thread.sleep(10000);                         
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }                    
                    }
            }
        });

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    
                    try {
                        Random rand = new Random();
                        int n = rand.nextInt(5);

                        System.out.println(strArray3[n]) ;      // 7
                        Thread.sleep(5000);                         

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }  
                   
                }
            }
        });
        
        t1.start();
        t2.start();            
        
       
        try {            
            t2.join();
            t1.stop();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        
    }    
}
