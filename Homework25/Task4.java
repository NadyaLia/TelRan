package Homework.Homework25;
public class Task4 {
    public static void main(String[] args) {
        int[] array = {-1, 4, 0, 2, 7, -3};
        int secondSmallest = findSecondSmallest(array);

        System.out.println(secondSmallest);
    }

    public static int findSecondSmallest(int[] array) {
        if (array.length < 2) {
            throw new IllegalArgumentException("The array should have more numbers");
        }

        int smallest = Math.min(array[0], array[1]);
        int secondSmallest = Math.max(array[0], array[1]);

        for (int i = 2; i < array.length; i++) {
            if (array[i] < smallest) {
                secondSmallest = smallest;
                smallest = array[i];
            } else if (array[i] < secondSmallest && array[i] != smallest) {
                secondSmallest = array[i];
            }
        }
        return secondSmallest;
    }
}
