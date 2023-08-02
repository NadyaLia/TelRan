package Homework.Homework25;

import java.util.HashSet;
import java.util.Set;

public class Task1 {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 5, 5, 8, 9, 7, 10};
        int[] array2 = {1, 0, 6, 15, 6, 4, 7, 0};

        Set<Integer> commonElements = findCommonElements(array1, array2);
        System.out.println(commonElements);
    }

    public static Set<Integer> findCommonElements(int[] array1, int[] array2) {
        Set<Integer> set = new HashSet<>();
        for (int number : array1) {
            set.add(number);
        }

        Set<Integer> commonElements = new HashSet<>();
        for (int number : array2) {
            if (set.contains(number)) {
                commonElements.add(number);
            }
        }
        return commonElements;
    }
}
