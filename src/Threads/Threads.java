package Threads;

public class Threads {
    private final Object mon = new Object();
    private boolean isTurnOne = true;
    private boolean isTurnTwo = true;
    private volatile int count = 0;
    private final int N = 5;

    public void printA(){
        synchronized (mon) {
            try {
                while(!isTurnOne){
                    mon.wait();
                }
                mon.notifyAll();
                System.out.print('A');
                count++;
                isTurnOne = false;
                mon.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void printB(){
        synchronized (mon) {
            try {
                while(isTurnOne) {
                    mon.wait();
                }
                mon.notifyAll();
                System.out.print('B');
                count++;
                isTurnTwo = false;
                mon.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void printC(){
        synchronized (mon) {
            try {
                while(isTurnTwo) {
                    mon.wait();
                }
                mon.notifyAll();
                System.out.print('C');
                count++;
                isTurnOne = true;
                isTurnTwo = true;
                if(count < N*3) mon.wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args){
        Threads trs = new Threads();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < trs.N; i++) {
                trs.printA();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < trs.N; i++) {
                trs.printB();
            }
        });
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < trs.N; i++) {
                trs.printC();
            }
        });
        t1.start();
        t2.start();
        t3.start();

    }
}
