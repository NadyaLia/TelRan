package Practice35.mulltithreading;

public class OrderedStart2 {
    private static volatile int nextNumber = 0;

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            int finalNum = i;
            new Thread(() -> {
                while (true) {
                    if (nextNumber == finalNum) {
                        System.out.println("Message " + finalNum);
                        nextNumber++;
                        break;
                    }
                }
            }).start();
        }
    }
}
