package io.github.tpalucki.others;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class CURL {

    // Printing the contents of a URL with transferTo, added in Java 9
    public static void main(String[] args) throws IOException {

        final String url = "https://onet.pl";
        final String filename = "target/onet.source.txt";

        try (InputStream in = new URL(url).openStream(); FileOutputStream out = new FileOutputStream(filename)) {
//            in.transferTo(System.out);
            in.transferTo(out);
        }
    }
}
