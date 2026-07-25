/**
 * Przed Java 25 this() lub super() musialo byc pierwszym wywołaniem w konstruktorze
 * teraz mozna zrobić np. walidacje lub przygotowanie zmiennej
 */
class Person {
    private final String name;

    public Person(String name) {
        this.name = name;
    }
}

class Employee extends Person {
    private final String role;

    public Employee(String name, String role) {
        // 1. Walidacja bezpośrednio w konstruktorze przed super()
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Imię nie może być puste!");
        }

        // 2. Przygotowanie zmiennej lokalnej
        String formattedName = name.trim().toUpperCase();

        // 3. Wywołanie konstruktora klasy bazowej w dogodnym momencie
        super(formattedName);

        // 4. Dalsza inicjalizacja własnych pól
        this.role = role;
    }
}

//class FlexibleConstructors {
void main() {
    Employee employee = new Employee("  John Doe  ", "Developer");
    System.out.println("Employee created: " + employee);
}
//}