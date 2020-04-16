package Lesson4;

public class WaitNotifyClass {

    private volatile char curWord = 'A';

    public static void main(String[] args) {
        final WaitNotifyClass wnc = new WaitNotifyClass();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                wnc.printA();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                wnc.printB();
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                wnc.printC();
            }
        });

        t1.start();
        t2.start();
        t3.start();

    }

    public synchronized void printA(){
        try {
            for (int i = 0; i < 5; i++) {
                while (curWord != 'A'){
                    wait();
                }
                System.out.print("A");
                curWord = 'B';
                notifyAll();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public synchronized void printB(){
        try {
            for (int i = 0; i < 5; i++) {
                while (curWord != 'B'){
                    wait();
                }
                System.out.print("B");
                curWord = 'C';
                notifyAll();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public synchronized void printC(){
        try {
            for (int i = 0; i < 5; i++) {
                while (curWord != 'C'){
                    wait();
                }
                System.out.print("C");
                curWord = 'A';
                notifyAll();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
