package Homework.Homework25;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class Task3Test {
    private int[] array;

    @Before
    public void init() {
        array = new int[] {-1, 4, 0, 2, 7, -3};
    }

    @Test
    public void checkFindSecondLargest() {
        int expected = 4;
        int actual = Task3.findSecondLargest(array);
        assertEquals(expected, actual);
    }

    @Test
    public void checkNotNull() {
        assertNotNull(array);
    }

    @Test
    public void checkAllSameElements() {
        int[] array = {1, 1, 1, 1, 1};
        int expected = 1;
        int actual = Task3.findSecondLargest(array);
        assertEquals(expected, actual);
    }

    @Test
    public void checkFewerElements() {
        int[] array = {1};
        int[] array1 = {};
        assertThrows(IllegalArgumentException.class, () -> Task3.findSecondLargest(array));
        assertThrows(IllegalArgumentException.class, () -> Task3.findSecondLargest(array1));
    }
}