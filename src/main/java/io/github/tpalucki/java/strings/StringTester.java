package io.github.tpalucki.java.strings;

public class StringTester {

    static void main(String[] args) {
        "".isBlank();
        "".isEmpty();

        // different array initialization
        String a[] = "abc def ghi".split(" ");
        String[] b = "abc def ghi".split(" ");
        String[] c = "abc def ghi".split(" ");
        System.out.println(a[0] + " " + a[1] + " " + a[2]);
        System.out.println(b[0] + " " + b[1] + " " + b[2]);
        System.out.println(c[0] + " " + c[1] + " " + c[2]);


        "askdhak".toLowerCase();
        "askdhak".toUpperCase();

        "asdasdas".lines();

        var multiLineText = """
                -------
                This is multi line string
                And here we go with another line
                -------
                """.trim();

        IO.print(multiLineText);
    }
}
