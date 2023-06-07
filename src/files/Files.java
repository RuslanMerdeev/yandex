package files;

import java.io.*;

public class Files {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("src/files/inlines.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/files/outlines.txt"));
        String line;

        while (reader.ready()) {
            line = reader.readLine();
            writer.write(line);
            writer.newLine();
        }
        writer.flush();
    }
}
