package ch.zhaw.iwi.devops.stringCalculator;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringCalculator {
    public int Add(String numbers) throws NumberFormatException {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        String[] numberArray = numbers.split("[,\n]");
        String negativeNumbers = Arrays.stream(numberArray)
                .filter(number -> Integer.parseInt(number) < 0)
                .collect(Collectors.joining(","));

        if (!negativeNumbers.isEmpty()) {
            throw new NumberFormatException("No negative numbers allowed: " + negativeNumbers);
        }

        return Arrays.stream(numberArray)
                .mapToInt(Integer::parseInt)
                .filter(number -> number < 1000)
                .sum();
    }
}
