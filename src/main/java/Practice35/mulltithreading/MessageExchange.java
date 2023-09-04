package Practice35.mulltithreading;

public class MessageExchange {
    public static void main(String[] args) {
        MessageExchanger<String> exchanger = new MessageExchanger<>();

        Thread firstThread = new Thread(new FirstThread(exchanger));
        Thread secondThread = new Thread(new SecondThread(exchanger));

        firstThread.start();
        secondThread.start();
    }
}

class MessageExchanger<String> {
    private String message;
    private boolean isMessageSet = false;


    public synchronized void setMessage(String message) {
        while (isMessageSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.message = message;
        isMessageSet = true;
        notifyAll();
    }

    public synchronized String getMessage() {
        while (!isMessageSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        isMessageSet = false;
        notifyAll();
        return message;
    }
}

class FirstThread implements Runnable {
    // Он создает строку "Привет, второй поток!" и обменивается этой строкой с вторым потоком.

    private final MessageExchanger<String> exchanger;

    public FirstThread(MessageExchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        String message = "Привет, второй поток!";
        exchanger.setMessage(message);
        System.out.printf("FirstThread received: %s%n", exchanger.getMessage());
    }
}

class SecondThread implements Runnable {
    // который будет запущен вторым. Он создает строку "Привет, первый поток!" и обменивается этой строкой с первым потоком.
    //Оба потока после обмена выводят на экран принятое сообщение.

    private final MessageExchanger<String> exchanger;

    SecondThread(MessageExchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        String message = "Привет, первый поток!";
        exchanger.setMessage(message);
        System.out.printf("SecondThread received: %s%n", exchanger.getMessage());
    }
}