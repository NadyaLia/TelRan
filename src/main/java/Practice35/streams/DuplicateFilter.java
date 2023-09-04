package Practice35.streams;

import java.util.List;

public class DuplicateFilter {

    public static void removeNegatives(List<Integer> list) {
        list.removeIf(x -> x < 0);
    }

    public static void removePositives(List<Integer> list) {
        list.removeIf(x -> x > 0);
    }

    public static void removeEven(List<Integer> list) {
        list.removeIf(x -> x % 2 == 0);
    }

    public static void removeOdd(List<Integer> list) {
        list.removeIf(x -> x % 2 != 0);
    }
}
