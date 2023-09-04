package Practice35.input_output;

import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class EmailPrefixSearcherTest {
    @Test
    public void testGetEmailsWithPrefix() {
        File file = new File("C:/TelRan/Java/javaPro/src/main/java/testFile.txt");
        EmailPrefixSearcher searcher = new EmailPrefixSearcher(file);
        List<String> expected = Arrays.asList("test1@gmail.com", "test2@outlook.com");
        List<String> actual = searcher.getEmails("test");
        assertEquals(expected, actual);
    }

    @Test
    public void testNoMatchPrefix() {
        File file = new File("C:/TelRan/Java/javaPro/src/main/java/testFile.txt");
        EmailPrefixSearcher searcher = new EmailPrefixSearcher(file);
        List<String> expected = Arrays.asList();
        List<String> actual = searcher.getEmails("lia");
        assertEquals(expected, actual);
    }
}