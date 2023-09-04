package Practice35.streams;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CollectionDividerTest {
    @Test
    public void testDivideCollection() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        // when
        CollectionDivider.divideCollection(numbers, even, odd);
        // then
        assertEquals(Arrays.asList(2, 4, 6), even);
        assertEquals(Arrays.asList(1, 3, 5), odd);
    }

    @Test
    public void noOddNumbers() {
        List<Integer> numbers = Arrays.asList(2, 4, 6);
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        CollectionDivider.divideCollection(numbers, even, odd);
        assertEquals(Arrays.asList(2, 4, 6), even);
    }

    @Test
    public void emptyList() {
        List<Integer> numbers = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        CollectionDivider.divideCollection(numbers, even, odd);
        assertEquals(new ArrayList<>(), even);
        assertEquals(new ArrayList<>(), odd);
    }
}