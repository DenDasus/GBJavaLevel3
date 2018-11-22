package Lesson_5.MFU;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class MFU {
    ExecutorService printService = Executors.newFixedThreadPool(1);
    ExecutorService scanService = Executors.newFixedThreadPool(1);
    
    private void print(String doc, int n) throws InterruptedException {
        System.out.println("Начало печати");
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        
        Thread.sleep(100);
        
        System.out.println("Конец печати");
    }
    
    private void scan(String doc, int n) throws InterruptedException {
        System.out.println("Начало сканирования");
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        
        Thread.sleep(100);
        
        System.out.println("Конец сканирования");
    }
    
    public void addPrintWork(String doc, int n) {
        printService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    print(doc, n);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public void addScanWork(String doc, int n) {
        scanService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    scan(doc, n);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public static void main(String[] args) {
        MFU mfu = new MFU();
        
        mfu.addPrintWork("Doc 1", 10);
        mfu.addPrintWork("Doc 2", 5);
        mfu.addScanWork("Doc 3", 3);
        
        mfu.printService.shutdown();
        mfu.scanService.shutdown();
    }
}