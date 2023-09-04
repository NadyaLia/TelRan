package Practice35.streams;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ElementMultiplierTest {
    @Test
    public void testMultiplyElements() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> result = ElementMultiplier.multiplyElements(list, 2);
        assertEquals(Arrays.asList(2, 4, 6, 8, 10), result);
    }

    @Test
    public void multiplyToZero() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> result = ElementMultiplier.multiplyElements(list, 0);
        assertEquals(Arrays.asList(0, 0, 0, 0, 0), result);
    }

    @Test
    public void emptyList() {
        List<Integer> list = Arrays.asList();
        List<Integer> result = ElementMultiplier.multiplyElements(list, 2);
        assertEquals(Arrays.asList(), result);
    }
}