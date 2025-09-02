package io.github.tpalucki.java.concurrency.oracle.producerConsumer;


/**
 * <a href="https://docs.oracle.com/javase/tutorial/essential/concurrency/guardmeth.html">...</a>
 */
class ProducerConsumerExample {

    public static void main(String[] args) {
        Drop drop = new Drop();

        var producer = new Producer(drop);
        var consumer = new Consumer(drop);

        new Thread(consumer).start();
        new Thread(producer).start();
    }
}
