package addhw5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

    public class MFU {

        Object printLock = new Object();
        Object scanLock = new Object();

        public void print(String doc, int n) {
            synchronized (printLock) {
                System.out.println("Начало печати документа: " + doc);
                for (int i = 1; i <= n; i++) {
                    System.out.println("Печать страницы: " + i + " документа: " + doc);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("Конец печати документа: " + doc);
            }
        }

        public void scan(String doc, int n) {
            synchronized (scanLock) {
                System.out.println("Начало сканирования документа: " + doc);
                for (int i = 1; i <= n; i++) {
                    System.out.println("Сканирование страницы: " + i + " документа: " + doc);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("Конец сканирования документа: " + doc);
            }
        }

        public static void main(String[] args) {
        final MFU mfu = new MFU();
       CyclicBarrier cb = new  CyclicBarrier(3);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    mfu.print("Doc 1", 5);
                    cb.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    mfu.print("Doc 2", 5);
                    cb.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    mfu.scan("Doc 3", 10);
                    cb.await();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }

}