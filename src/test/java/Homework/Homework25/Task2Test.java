package Homework.Homework25;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class Task2Test {
    private int[] array;

    @Before
    public void init() {
        array = new int[] {0, 3, -2, 4, 3, 2};
    }

    @Test
    public void checkRemoveDuplicates() {
        int[] expected = {0, 3, -2, 4, 2};
        int[] actual = Task2.removeDuplicates(array);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void checkNotNull() {
        assertNotNull(array);
    }

    @Test
    public void checkWithNoDuplicates() {
        int[] array = {1, 2, 3, 4};
        int[] expected = {};
        int[] actual = Task2.removeDuplicates(array);
    }
}