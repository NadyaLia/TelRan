package Practice35.mulltithreading;

import java.util.concurrent.*;

public class OrderedStart {
    public static void main(String[] args) {
        ScheduledExecutorService service = new ScheduledThreadPoolExecutor(3);

        service.schedule(() -> {
            System.out.println("Second message");
        }, 4, TimeUnit.SECONDS);

        service.schedule(() -> {
            System.out.println("First message");
        }, 2, TimeUnit.SECONDS);

        service.schedule(() -> {
            System.out.println("Third message");
        }, 6, TimeUnit.SECONDS);

        service.shutdown();
    }
}
