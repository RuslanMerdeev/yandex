package a2023_08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Repeats_ {

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new FileWriter("outlines.txt"));
        Integer number;
        Integer current = null;

        r.readLine();

        while(r.ready()) {
            number = Integer.parseInt(r.readLine());
            if (!number.equals(current)) {
                writer.write(number.toString());
                writer.newLine();
                current = number;
            }
        }
        writer.flush();
    }
}
