package io.github.tpalucki.java.io;

import java.io.*;
import java.util.List;

public class JavaIoPackageUsage {

    /**
     * Stream to jest ciąg jakiś wartośi.
     * Aby na nich operowac w javie mamy java.io oraz implementacje różnych Input/Output Streamow
     */
    public static void main(String[] args) {
        inputStreams();

        objectStreams();
    }

    private static void inputStreams() {
        // input stream to jest klasa nadrzędna streamów, reprezentuje przychodzący stream byte
        try (InputStream inputStream = new FileInputStream("./file.ser")) {

            List.of(
                    new FileInputStream("./file.stream"), // do czytania z pliku
                    new DataInputStream(inputStream),           // dy czytania primitive types z innego InputStream
//                    new java.io.FilterInputStream(inputStream),       // protected, służy do transformacji streamow
                    new BufferedInputStream(inputStream),       // bufor na innym input stream. Gdy czytamy to
                                                                        // wewnatrzna tablica jest wypelniana kolejnymi bajtami ze streamu
                    new ByteArrayInputStream("Any str".getBytes()) // do czytania z tablicy bajtów
            );

            // odczyt
            inputStream.read();
            inputStream.readNBytes(10);
            inputStream.readAllBytes();

            // dzięki klasom *Reader możemy odczytywac tekst
            BufferedReader reader = new BufferedReader(new FileReader("/file.ser"));

            reader.readLine();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    static class Animal implements java.io.Serializable {
        final String name;

        public Animal(String name) {
            this.name = name;
        }
    }

    /**
     * Object stream służą do przesyłania obiektów Javovych
     */
    private static void objectStreams() {
        // obiekt musi implementowa @Serializable
        try (java.io.OutputStream fileStream = new FileOutputStream("./object.ser");
             java.io.InputStream fileInputStream = new FileInputStream("./object.ser")) {
            ObjectOutput objectOutput = new ObjectOutputStream(fileStream);

            objectOutput.writeObject(new Animal("koza"));

            ObjectInput objectInput = new java.io.ObjectInputStream(fileInputStream);
            Animal animalFromStream = (Animal) objectInput.readObject();
            System.out.println("animalFromStream.name = " + animalFromStream.name);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
