package io.github.tpalucki.java.interfaces;


/**
 * Wszystkie pola i metody są z automatu publiczne z interfejsie - nie trzeba dodawac modyfikatora `public`
 * Interfejs oczywiscie może by publiczny lub package-private
 */
interface Cat {

    /**
     * Pola w interfejscie są z automatu publiczne i finalne
     */
    int EYES = 2;
    public final int LEGS = 4; // <- nie ma potrzeby żeby dodawac modyfikatorów 'public final'

    /**
     * Metoda domyślna (default) dostarcza domyslna implementację metody w interfejsie, tzn klasa implementująca
     * nie musi dostarcza implementacji takiej metody
     */
    default int getEyesNumber() {
        return EYES;
    }

    default int getLegs() {
        return LEGS;
    }


    /**
     * Zauważ że public jest opcjonalne - wszystkie metody z automatu są publiczne
     */
    public static void main(String[] args) {

    }
}
