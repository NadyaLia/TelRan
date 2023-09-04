package Practice35.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NumberCounter {
    public static Map<Integer, Integer> countOccurrences(List<Integer> list) {
        return list.stream().collect(Collectors.toMap(x -> x, x -> 1, (x1, x2) -> x1 + x2));
    }
}
