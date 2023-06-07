package console;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Console {

    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String line;

        r.readLine();

        do {
            line = r.readLine();
            System.out.println(line);
        } while (r.ready());
    }
}
