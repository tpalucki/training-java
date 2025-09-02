package io.github.tpalucki.tdd;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * All requirements in test class
 */
class Calculator {

    private final static String NEGATIVE_NUMBER_MESSAGE = "negatives not allowed ";
    private final static String DEFAULT_DELIMITER = ",";
    private final static String NEW_LINE = "\n";
    private final static String DELIMITER_END_BRACE = "]";
    private final static String REGEXP_OR_OPERATOR = "|";


    int add(final String numbers) {
        var delimiters = new ArrayList<>(List.of(DEFAULT_DELIMITER));

        var numbersWithoutDelimiter = numbers;
        if (numbers.startsWith("//")) {
            var parts = numbers.substring(2).split(NEW_LINE);
            numbersWithoutDelimiter = parts[1];

            var delimiterString = parts[0];

            var a = delimiterString.split(DELIMITER_END_BRACE);
            for (String d : a) {
                if (d.isEmpty()) {
                    continue;
                }
                delimiters.add(d.substring(1));
            }

        }

        var regexBuilder = new StringBuilder();
        delimiters.forEach((s) -> regexBuilder.append(s).append(REGEXP_OR_OPERATOR));
        regexBuilder.append(Pattern.quote(NEW_LINE));
        String[] parts = numbersWithoutDelimiter.split(regexBuilder.toString());
        List<Integer> negatives = new LinkedList<>();
        var sum = 0;
        if (!numbersWithoutDelimiter.isEmpty()) {
            for (String s : parts) {
                var parsedInt = Integer.parseInt(s);
                if (parsedInt < 0) {
                    negatives.add(parsedInt);
                } else if (parsedInt > 1000) {
                    continue;
                }
                sum += parsedInt;
            }
        }

        if (!negatives.isEmpty()) {
            throw new RuntimeException(NEGATIVE_NUMBER_MESSAGE + negatives.toString());
        }

        return sum;
    }
}
