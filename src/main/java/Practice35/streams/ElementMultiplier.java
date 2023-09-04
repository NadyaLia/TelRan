package Practice35.streams;

import java.util.List;
import java.util.stream.Collectors;

public class ElementMultiplier {
    public static List<Integer> multiplyElements(List<Integer> list, int k) {
        return list.stream().map(x -> x * k).collect(Collectors.toList());
    }
}
