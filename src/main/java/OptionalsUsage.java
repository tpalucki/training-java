void main() {
    var opt = Optional.<String>empty();


    // map vs flatMap
    Optional<String> resultOptional = opt.map(String::toUpperCase);
    // tylko jesli mapping function tez zwaraca optional, dodane zeby nie bylo Optional<Optional<String>> (czyli zagnieżdżonego optionala)
    Optional<String> resultValue = opt.flatMap(s -> Optional.of(s.toUpperCase()));
}


record Apple(
        String color,
        int weight,
        /**
         *  makes no sense:
         *  - breaks serializaiont (non mutable)
         *  - doesn't bring value to the table
         *  - just a wrapper
         */
        Optional<String> name
) {


    /**
     * designed as return type to indicate optionality
     */
    public <T> Optional<T> method() {
        return Optional.empty();
    }

}