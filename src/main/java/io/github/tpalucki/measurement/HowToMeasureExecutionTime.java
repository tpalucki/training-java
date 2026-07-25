package io.github.tpalucki.measurement;

import java.time.Duration;
import java.time.Instant;

class HowToMeasureExecutionTime {

    void doSth() throws InterruptedException {
        Instant start = Instant.now();
        Thread.sleep(5000);

        Instant end = Instant.now();
        IO.println("Time spent on execution: " + Duration.between(start, end).toMillis());
    }

}
