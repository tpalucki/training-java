package io.github.tpalucki.java.records;

import java.math.BigDecimal;


/**
 * Co daje rekord?
 *
 * - automatyczny konstruktor dla pól
 * - pola prywatne i finalne
 * - gettery
 * - implementacja hashCode() i equals()
 * - implementacja toString(), która zawiera wsyzstkie pola
 */
public record Payment(Long id,
               BigDecimal amount,
               String fromAccount,
               String toAccount) {

    public static void main(String[] args) {
        var paymentRecord = new Payment(1L, BigDecimal.TEN, "Account A", "Account B");

        System.out.println("record.toString = " + paymentRecord);
        System.out.println("record.hashCode() = " + paymentRecord.hashCode());
        System.out.println("record.equals(\"test\") = " + paymentRecord.equals("test"));
        System.out.println("record.getFrom() = " + paymentRecord.fromAccount());

        // dostępne są gettery
        paymentRecord.fromAccount();
        paymentRecord.id();

        // operujemy wewnatrz klasy więc mamy dostęp do pól
//        paymentRecord.fromAccount = ""; // pole jest finalne i prywatne!!!
    }
}
