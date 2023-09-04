package Practice35.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionDivider {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(6, 3, 8, 9, 1, 0, 5, 2, 4);
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        divideCollection(list, even, odd);

        System.out.println(even);
        System.out.println(odd);
    }

    public static void divideCollection(List<Integer> numbers, List<Integer> even, List<Integer> odd) {
        even.addAll(numbers.stream().filter(x -> x % 2 == 0).collect(Collectors.toList()));
        odd.addAll(numbers.stream().filter(x -> x % 2 != 0).collect(Collectors.toList()));
    }
}
