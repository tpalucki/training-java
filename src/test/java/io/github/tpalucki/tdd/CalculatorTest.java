package io.github.tpalucki.tdd;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


/**
 * REQUIREMENTS
 * Create a simple String calculator with a method int Add(string numbers)
 * The method can take 0, 1 or 2 numbers, and will return their sum (for an empty string it will return 0) for example "" or "1" or "1,2"
 * Allow the Add method to handle an unknown amount of numbers
 * Allow the Add method to handle new lines between numbers (instead of commas).
 * The following input is ok: "1\n2,3" (will equal 6)
 * Support different delimiters
 * To change a delimiter, the beginning of the string will contain a separate line that looks like this: "//[delimiter]\n[numbers…]" for example "//;\n1;2" should return three where the default delimiter is ';' .
 * The first line is optional. All existing scenarios should still be supported
 * Calling Add with a negative number will throw an exception "negatives not allowed" - and the negative that was passed. If there are multiple negatives, show all of them in the exception message stop here if you are a beginner.
 * Numbers bigger than 1000 should be ignored, so adding 2 + 1001 = 2
 * Delimiters can be of any length with the following format: "//[delimiter]\n" for example: "//[---]\n1---2---3" should return 6
 * Allow multiple delimiters like this: "//[delim1][delim2]\n" for example "//[-][%]\n1-2%3" should return 6.
 * Make sure you can also handle multiple delimiters with length longer than one char
 */
class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void whenTwoNumbersPassedThenShouldAdd() {
        assertEquals(10, calculator.add("1,9"));
    }

    @Test
    void whenEmptyStringPassedThenReturnZero() {
        assertEquals(0, calculator.add(""));
    }

    @Test
    void whenOneNumberPassedThenReturnThatNumber() {
        assertEquals(5, calculator.add("5"));
    }

    @Disabled
    @Test
    void whenMoreThanTwoNumbersThenShouldThrowException() {
        assertThrows(RuntimeException.class, () -> calculator.add("1,2,3"));
    }

    @Test
    void whenMoreThanTwoNumbersThenTheyAreHandledAndSumReturned() {
        assertEquals(20, calculator.add("1,2,3,4,10"));
    }

    @Test
    void whenNewLinePassedBetwenNumbersThenTheyAreHandledAndSumReturned() {
        assertEquals(20, calculator.add("1,2\n3,4,10"));
    }

    @Test
    void whenStartsWithDelimiterChangingSequenceThenDelimiterChanged() {
        assertEquals(3, calculator.add("//[;]\n1;2"));
    }

    @Test
    void whenStartsWith2SignDelimiterChangingSequenceThenDelimiterChanged() {
        assertEquals(3, calculator.add("//[;;]\n1;;2"));
    }

    @Test
    void whenNegativePassedThenExceptionThrown() {
        var exceptionThrown = assertThrows(RuntimeException.class, () -> calculator.add("-1,2"));
        assertEquals("negatives not allowed [-1]", exceptionThrown.getMessage());
    }

    @Test
    void whenNegativesPassedThenExceptionThrown() {
        assertThrows(RuntimeException.class, () -> calculator.add("-1,2,-3"));
    }

    @Test
    void whenNegativesPassedThenExceptionThrownWithTheseNegativesInMessage() {
        try {
            calculator.add("-1,2,-3");
        } catch (RuntimeException exceptionThrown) {
            assertEquals("negatives not allowed [-1, -3]", exceptionThrown.getMessage());
            return;
        }
        fail();
    }

    @Test
    void whenNumberBiggerThan1000PassedThenShouldBeIgnored() {
        assertEquals(3, calculator.add("1,10000,2,1001"));
    }

    @Test
    void whenDelimiterLongerThanOneCharThenDelimiterChanged() {
        assertEquals(3, calculator.add("//[;;]\n1;;2"));
    }

    @Test
    void whenMultipleDelimitersThenDelimiterChanged() {
        assertEquals(6, calculator.add("//[;;][__]\n1;;2__3"));
    }

}