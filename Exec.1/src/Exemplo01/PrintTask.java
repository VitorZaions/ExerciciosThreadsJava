package Exemplo01;

import java.util.Random;

public class PrintTask implements Runnable {
    //ou public class PrintTask extends Thread {
    // Tempo de adormecimento aleatório para a thread
    private int sleepTime;
    
    // Nome da thread
    private String threadName;
    
    // Gerador de números aleatórios
    private static Random generator = new Random();
    
    // Construtor com o nome da thread
    public PrintTask(String name) {
        this.threadName = name; // Atribui o nome da thread
        
        // Gerar um tempo aleatório entre 0 a 5 segundos
        this.sleepTime = generator.nextInt(6) * 1000 + 1000;
    }

    // Método a ser executado pela thread (main do thread)
    @Override
    public void run() {
        
        // Coloca a thread para dormir pela qtd de tempo definida em sleeepTime
       // try {
            System.out.printf("\nA thread %s executou ", this.threadName/*, this.sleepTime*/);
           // Thread.sleep(this.sleepTime);
       // }
       // catch (InterruptedException ex) {
            // se a thread for interrompeida enquanto dorme, imprime erro
       //     ex.printStackTrace();
      //  }
        
        // Imprime que a thread acordou
      //  System.out.printf("\nA thread %s acordou!", this.threadName);
    }    
}
