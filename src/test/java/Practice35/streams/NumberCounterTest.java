package Practice35.streams;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class NumberCounterTest {
    @Test
    public void testCountOccurrences() {
        List<Integer> list = Arrays.asList(1, 1, 2, 3, 3, 3);
        Map<Integer, Integer> expected = new HashMap<>();
        Map<Integer, Integer> actual = NumberCounter.countOccurrences(list);
        expected.put(1, 2);
        expected.put(2, 1);
        expected.put(3, 3);
        assertEquals(expected, actual);
    }

    @Test
    public void emptyList() {
        List<Integer> list = Arrays.asList();
        Map<Integer, Integer> actual = NumberCounter.countOccurrences(list);
        assertEquals(new HashMap<>(), actual);
    }
}