package a2023_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Repeats {

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        Integer number;
        Integer current = null;

        r.readLine();

        while(r.ready()) {
            number = Integer.parseInt(r.readLine());
            if (!number.equals(current)) {
                System.out.println(number);
                current = number;
            }
        }
    }
}
