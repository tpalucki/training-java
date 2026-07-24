package io.github.tpalucki.vistulo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

class VistuloNumbersFilterTest {

    @Nested
    class BasicFlowCorrectness {
        @Test
        public void onlyNegatives() {
            int[] input = {-1, -2, -3};
            List<Integer> expectedOutput = List.of(-1, -2, -3);

            var result = VistuloNumbersFilter.processArray(input);

            assertEquals(expectedOutput, result);
        }

        @Test
        public void onlyPositive() {
            int[] input = {1, 2, 3};
            List<Integer> expectedOutput = Collections.emptyList();

            var result = VistuloNumbersFilter.processArray(input);

            assertEquals(expectedOutput, result);
        }

        @Test
        public void ifPositiveHigherThanItemsAlreadyProcessedThenShouldSkipIt() {
            int[] input = {-1, -2, 10, -3};
            List<Integer> expectedOutput = List.of(-1, -2, -3);

            var result = VistuloNumbersFilter.processArray(input);

            assertEquals(expectedOutput, result);
        }

        @Test
        public void shouldSkipZero() {
            int[] input = {-1, 0, -2, 0, -3};
            List<Integer> expectedOutput = List.of(-1, -2, -3);

            var result = VistuloNumbersFilter.processArray(input);

            assertEquals(expectedOutput, result);
        }

        @Test
        public void shouldRemovedBasedOnPositive() {
            int[] input = {-1, -2, -3, 2};
            List<Integer> expectedOutput = List.of(-1, -3);

            var result = VistuloNumbersFilter.processArray(input);

            assertEquals(expectedOutput, result);
        }
    }

    @Nested
    class RandomFlowCorrectness {
        @Test
        public void processingRandomOutputShouldContainOnlyNegatives() {
            int[] input = generateSampleArray(1000);
            List<Integer> expectedOutput = calculateNaively(input);

            var result = VistuloNumbersFilter.processArray(input);

            assertEquals(expectedOutput, result);
            assertTrue(result.stream()
                    .allMatch(i -> i < 0)); // all negative in output, no zeros
        }

        @Test
        @Timeout(value = 100, unit = java.util.concurrent.TimeUnit.MILLISECONDS)
        public void processingHugeShouldBeQuick() {
            int inputSize = 10000000;
            int[] input = generateSampleArray(inputSize);
            assertEquals(inputSize, input.length);
//            List<Integer> expectedOutput = calculateNaively(input);

            var result = VistuloNumbersFilter.processArray(input);

//            assertEquals(expectedOutput, result);
            assertTrue(result.stream()
                    .allMatch(i -> i < 0)); // all negative in output, no zeros
        }
    }

    private int[] generateSampleArray(int size) {
        return ThreadLocalRandom.current()
                .ints(size, -255, 256)
                .toArray();
    }

    private List<Integer> calculateNaively(int[] input) {
        List<Integer> outputProcessed = new LinkedList<>();

        if (input == null) {
            return outputProcessed;
        }
        for (int current : input) {
            if (current == 0) {
                continue;
            }
            if (current < 0) {
                outputProcessed.add(current);
            }
            if (current > 0) {
                if (outputProcessed.size() >= current) {
                    // remove only if enough elements
                    outputProcessed.remove(current - 1);
                }
            }
        }

        return outputProcessed;
    }
}

