/**
 * Task is to find the first unique character in a string. If there is no unique character, return 0 (print it).
 * Consider letters lowercase
 */
void main() {
    var input = "Abba"; // no unique so expect number 0
//    input = "Google"; // expected l
//    input = "Home"; // expected h

    Map<Character, Integer> charCountMap = new LinkedHashMap<>();

    input.chars().forEach(c -> {
        var lowerCaseChar = Character.toLowerCase(c);
        charCountMap.put((char) lowerCaseChar, charCountMap.getOrDefault((char) lowerCaseChar, 0) + 1);
    });

    var uniqueEntry = charCountMap.entrySet()
            .stream()
            .filter(entry -> entry.getValue() == 1)
            .findFirst();

    var foundUniqueCharacter = uniqueEntry.map(Map.Entry::getKey);

    IO.println(foundUniqueCharacter.map(Object::toString)
            .orElse("0"));

}
