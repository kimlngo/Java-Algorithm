package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadText {

    public static String readLine(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line = reader.readLine();
        reader.close();

        return line;
    }
}
