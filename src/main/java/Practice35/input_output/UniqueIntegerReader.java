package Practice35.input_output;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueIntegerReader {
    public List<Integer> read(File file) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        List<Integer> resultList = new ArrayList<>();

        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;

            while ((line = in.readLine()) != null) {
                String[] numbers = line.split("\\s+");
                for (String numberString : numbers) {

                    if (!numberString.equals("")) {
                        int number = Integer.parseInt(numberString);
                        if (uniqueNumbers.add(number)) {
                            resultList.add(number);
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return resultList;
    }
}
