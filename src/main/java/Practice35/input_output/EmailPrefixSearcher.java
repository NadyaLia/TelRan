package Practice35.input_output;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmailPrefixSearcher {
    private final List<String> emails;
    public EmailPrefixSearcher(File file) {
        emails = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                emails.add(line.trim());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getEmails(String prefix) {
        return emails.stream().filter(email -> email.startsWith(prefix)).collect(Collectors.toList());
    }
}
