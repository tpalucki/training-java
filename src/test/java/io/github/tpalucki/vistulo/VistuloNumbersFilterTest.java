package io.github.tpalucki.vistulo;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

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
}