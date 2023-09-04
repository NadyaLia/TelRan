package Practice35.input_output;

import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UniqueIntegerReaderTest {
    @Test
    public void testUniqueIntegers() {
        File file = new File("C:/TelRan/Java/javaPro/src/main/java/output.txt");
        UniqueIntegerReader reader = new UniqueIntegerReader();
        List<Integer> uniqueNumbers = reader.read(file);
        List<Integer> expected = Arrays.asList(1, 2, 3);
        assertEquals(expected, uniqueNumbers);
    }
}