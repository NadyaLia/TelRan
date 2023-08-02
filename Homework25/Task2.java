package Homework.Homework25;

import java.util.Arrays;
import java.util.LinkedHashSet;

public class Task2 {
    public static void main(String[] args) {
        int[] array = {0, 3, -2, 4, 3, 2};
        int[] withoutDuplicates = removeDuplicates(array);

        for (int i : withoutDuplicates) {
            System.out.print(i + " ");
        }
    }

    public static int[] removeDuplicates(int[] array) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int number : array) {
            set.add(number);
        }
        int[] withoutDuplicates = new int[set.size()];
        int i = 0;
        for (int number : set) {
            withoutDuplicates[i++] = number;
        }
        return withoutDuplicates;
    }
}
