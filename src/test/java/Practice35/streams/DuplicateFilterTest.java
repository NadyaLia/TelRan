package Practice35.streams;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DuplicateFilterTest {
    @Test
    public void testRemoveNegatives() {
        List<Integer> list = new ArrayList<>(Arrays.asList(-1, -2, 3, -4));
        DuplicateFilter.removeNegatives(list);
        assertEquals(Arrays.asList(3), list);
    }

    @Test
    public void testRemovePositives() {
        List<Integer> list = new ArrayList<>(Arrays.asList(-1, -2, 3, -4));
        DuplicateFilter.removePositives(list);
        assertEquals(Arrays.asList(-1, -2, -4), list);
    }

    @Test
    public void testRemoveEven() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        DuplicateFilter.removeEven(list);
        assertEquals(Arrays.asList(1, 3), list);
    }

    @Test
    public void testRemoveOdd() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        DuplicateFilter.removeOdd(list);
        assertEquals(Arrays.asList(2, 4), list);
    }
}