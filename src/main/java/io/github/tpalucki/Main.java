package io.github.tpalucki;

public class Main {

    public static void main(String[] args) {
        // lets create Person using builder pattern
        final Person person = new Person
                .Builder("John", "Doe")
                .height(180)
                .nick("Gonzo")
                .build();

        // trying to create abstract class
//        Pizza pizza = new Pizza();

    }

//    public static void main(String[] args) {
//        System.out.println("Main started");
//        // zadanie 1 - sprawdzmy cos ię dzieje gdy wyślemy interrupted od działającego wątku. Czy zostanie przerwany, czy będzie dział dalej.
////        Thread t1 = new Thread(new ToBeInterruptedRunnable());
////        t1.start();
////
////        Thread.sleep(2000);
////
////        t1.interrupt();
//
//        // zadanie 2 - jak działają joiny na wątkach
//        // startujemy 1 wątek, i joinujemy obecny aż się tamten zakończy
////        Thread toBeJoined = new Thread(new WaitTwoSecondsRunnable());
////        toBeJoined.start();
////        // magic
////        try {
////            toBeJoined.join();
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
////        System.out.println("toBeJoined finished, so here we go");
//
//        // zadanie 3 - producer, consumer
////        Drop drop = new Drop();
////        (new Thread(new Producer(drop))).start();
////        (new Thread(new Consumer(drop))).start();
//
//////        zadanie 4 - odpalamy z wykorzystaniem Executors
////        Executor e = Executors.newSingleThreadExecutor();
////        e.execute(new WaitTwoSecondsRunnable());
////
////        Callable<String> callable = () -> {
////            Thread.sleep(1000);
////            return "Working again!";
////        };
////
////        ExecutorService es = Executors.newSingleThreadExecutor();
////        Future<String> result = es.submit(callable);
////
////        String resultFinally;
////        try {
////            resultFinally = result.get();
////
////            System.out.println("Received from future: \"" + resultFinally + "\"");
////        } catch (InterruptedException ex) {
////            ex.printStackTrace();
////        } catch (ExecutionException ex) {
////            ex.printStackTrace();
////        }
//
//        MyCollections.show();
//    }

    /**
     * Builder pattern implementation for Person class
     */
    public static class Person {

        // required
        private String name;
        private String surname;

        // optional
        private long height = 200;
        private String nick;

        private Person(Builder builder) {
            this.name = builder.name;
            this.surname = builder.surname;
            this.height = builder.height;
            this.nick = builder.nick;
        }

        public static class Builder {

            private final String name;
            private final String surname;

            private long height;
            private String nick;

            public Builder(String name, String surname) {
                this.name = name;
                this.surname = surname;
            }

            public Builder height(long height) {
                this.height = height;
                return this;
            }

            public Builder nick(String nick) {
                this.nick = nick;
                return this;
            }

            public Person build() {
                return new Person(this);
            }
        }
    }
}
