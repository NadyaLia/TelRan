package Homework.Algorithms;

public class Homework4 {
    public static void main(String[] args) {
        int[] array1 = {100, 112, 256, 349, 770};
        int[] array2 = {72, 86, 113, 119, 265, 445, 892};
        int k = 7;

        int kElement = findKElement(array1, array2, k);
        System.out.println("The element at position " + k + " is: " + kElement);
    }

    public static int findKElement(int[] array1, int[] array2, int k) {
        int m = array1.length;
        int n = array2.length;
        int i = 0;
        int j = 0;
        int kElement = 0;

        while (i < m && j < n) {
            if (array1[i] <= array2[j]) {
                kElement = array1[i];
                i++;
            } else {
                kElement = array2[j];
                j++;
            }
            if (i + j == k) {
                return kElement;
            }
        }

        while (i < m) {
            kElement = array1[i];
            i++;
            if (i + j == k) {
                return kElement;
            }
        }

        while (j < n) {
            kElement = array2[j];
            j++;
            if (i + j == k) {
                return kElement;
            }
        }
        return kElement;
    }
}
