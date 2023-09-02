package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static void writeMessage(String message) {
        System.out.println(message);
    }
}
