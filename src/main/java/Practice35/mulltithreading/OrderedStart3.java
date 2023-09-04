package Practice35.mulltithreading;

import java.util.concurrent.CyclicBarrier;

public class OrderedStart3 {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(2);

        new Thread(() -> {
            while (true) {
                try {
                    System.out.println("Thread 1 msg");
                    Thread.sleep(1000);
                    barrier.await();
                    Thread.sleep(1000);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    barrier.await();
                    System.out.println("Thread 2 msg");
                    Thread.sleep(1000);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}
