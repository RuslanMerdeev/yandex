package a2022_06;

import java.io.*;

public class Ones_ {

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int max = 0;
        int current = 0;

        r.readLine();

        do {
            line = r.readLine();
            if (line.equals("1")) {
                current++;
            } else {
                if (max < current) {
                    max = current;
                }
                current = 0;
            }
        } while(r.ready());

        if (max < current) {
            max = current;
        }

        System.out.println(max);
    }
}
