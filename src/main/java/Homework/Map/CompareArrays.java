package Homework.Map;

import java.util.HashMap;
import java.util.Map;

public class CompareArrays {
    public static void main(String[] args) {
        int arr1[] = {1, 2, 5, 4, 0};
        int arr2[] = {2, 4, 5, 0, 1};


        boolean flag = isEqual(arr1, arr2);
            if (flag) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
    }

    public static boolean isEqual(int arr1[], int arr2[]) {
        if (arr1.length != arr2.length) {
            return false;
        }

        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int i : arr1) {
            if (map1.get(i) != null) {
                map1.put(i, map1.get(i) + 1);
            } else {
                map1.put(i, 1);
            }
        }

        for (int i : arr2) {
            if (map2.get(i) != null) {
                map2.put(i, map2.get(i) + 1);
            } else {
                map2.put(i, 1);
            }
        }

        if (map1.equals(map2)) {
            return true;
        }
        return true;
    }
}
