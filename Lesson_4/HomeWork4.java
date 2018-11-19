package Lesson_4;

public class HomeWork4 {
    public static void main(String[] args) {
        Object a = new Object();
        Object b = new Object();
        
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("A");
                    synchronized (a) {
                        a.notify();
                    }
                }
            }
        });
        
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    synchronized (a) {
                        try {
                            a.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("B");
                        synchronized (b) {
                            b.notify();
                        }
                    }
                }
                
            }
        });
        
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    synchronized (b) {
                        try {
                            b.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("C");
                }
            }
        });
        
        threadA.start();
        threadB.start();
        threadC.start();
        
        try {
            threadA.join();
            threadB.join();
            threadC.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
