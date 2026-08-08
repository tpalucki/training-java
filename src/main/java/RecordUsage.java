void main() {

    var deviceRecord = new Device("Radio", 15, "1234567890");
}

record Device(
        String name,
        int version,
        String serialNumber
) {}


// ADT + sealed classes + interface implemented by record
public sealed interface PaymentMethod permits CardPayment, BlikPayment, BankTransfer {
}

public record CardPayment(String cardNumber, String cvv) implements PaymentMethod {}
public record BlikPayment(String code) implements PaymentMethod {}
public record BankTransfer(String iban, String swift) implements PaymentMethod {}
