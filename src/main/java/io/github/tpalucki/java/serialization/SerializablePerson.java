package io.github.tpalucki.java.serialization;

import java.io.*;

/**
 * java.io.Serializable - to jest interfejs którym sygnalizujemy że dana klasa jest Serializowalna
 * Nie ma metod.
 * Jest to tzw Marker interface
 */
public class SerializablePerson implements java.io.Serializable {
    // jesli nie ma to przy probie serializacji: java.io.NotSerializableException

    // required
    private String name;
    private String surname;
    private transient int age;

    public SerializablePerson(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Override
    public String toString() {
        return "SerializablePerson{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }

    static void main() {
        SerializablePerson person = new SerializablePerson("Tomasz", "Pałucki", 28);
        FileOutputStream fileOutputStream;
        try {
            System.out.println("Serializing the object");
            fileOutputStream = new FileOutputStream("./object.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
            out.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileInputStream in;
        try {
            IO.println("Deserializing object from file.");

            in = new FileInputStream("./object.ser");
            ObjectInputStream objectIn = new ObjectInputStream(in);
            SerializablePerson deserialized = (SerializablePerson) objectIn.readObject();

            IO.println("Deserialized file: " + deserialized);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
