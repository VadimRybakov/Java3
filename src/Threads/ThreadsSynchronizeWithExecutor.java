package Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadsSynchronizeWithExecutor {
    ExecutorService executorService;
    public ThreadsSynchronizeWithExecutor(){
        executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new MyThread('A'));
            executorService.execute(new MyThread('B'));
            executorService.execute(new MyThread('C'));
        }
        executorService.shutdown();
    }
    static class MyThread implements Runnable {
        private final char symbol;

        public MyThread(char symbol) {
            this.symbol = symbol;
            new Thread(this);
        }

        public void run() {
            System.out.print(symbol);
        }
    }
    public static void main(String[] args) {
        new ThreadsSynchronizeWithExecutor();
    }
}
