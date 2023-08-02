package Homework.Homework25;

public class Task3 {
    public static void main(String[] args) {
        int[] array = {-1, 4, 0, 2, 7, -3};
        int secondLargest = findSecondLargest(array);
        System.out.println(secondLargest);
    }

    public static int findSecondLargest(int[] array) {
        if (array.length < 2) {
            throw new IllegalArgumentException("The array should have more numbers");
        }
        int largest;
        int secondLargest;

        if (array[0] > array[1]) {
            largest = array[0];
            secondLargest = array[1];
        } else {
            largest = array[1];
            secondLargest = array[0];
        }

        for (int i = 2; i < array.length; i++) {
            int number = array[i];
            if (number > largest) {
                secondLargest = largest;
                largest = number;
            } else if (number > secondLargest && number != largest) {
                secondLargest = number;
            }
        }
        return secondLargest;
    }
}
