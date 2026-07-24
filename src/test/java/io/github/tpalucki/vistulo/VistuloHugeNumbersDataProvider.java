package io.github.tpalucki.vistulo;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static io.github.tpalucki.vistulo.VistuloNumbersFilterTest.calculateNaively;

public class VistuloHugeNumbersDataProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        ThreadLocalRandom random = ThreadLocalRandom.current();

        int itemsToReplace = 1000;
        int outputSize = 1_000_000_0;
        int[] input = random.ints(outputSize, -255, 256).toArray();

        IntStream.range(0, itemsToReplace).forEach(i -> {
            // generate a random index to replace
            int indexToReplace = random.nextInt(outputSize);
            // generate a random positive number to replace with
            int replacementValue = random.nextInt(outputSize);

            // replace the value at the index with the replacement value
            input[indexToReplace] = replacementValue;
        });

        List<Integer> outputProcessed = calculateNaively(input);

        return Stream.of(Arguments.of(input, outputProcessed));
    }
}
