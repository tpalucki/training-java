// Wykorzystujemy Sealed interface to achieve ADT (Algebraic Data Types)
sealed interface OrderState permits Pending, Processed, Shipped {
}

record Pending() implements OrderState {
    public String amount() {
        return "100 USD";
    }
}

record Processed() implements OrderState {
    public String trackingId() {
        return "TRACK123";
    }
}

record Shipped() implements OrderState {
    public String deliveryTime() {
        return "Friday";
    }
}

// Czysta logika obsługi stanu bez zewnętrznych frameworków:
public String handleState(OrderState state) {
    return switch (state) {
        case Pending p -> "Processing order for " + p.amount();
        case Processed pr -> "Awaiting shipment: " + pr.trackingId();
        case Shipped s -> "Delivered at " + s.deliveryTime();
    };
}

void main() {
    handleState(new Pending());
    handleState(new Processed());
    handleState(new Shipped());
}