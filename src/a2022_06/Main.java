package a2022_06;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String line;
        Set<Integer> set = new LinkedHashSet<>();

        r.readLine();

        do {
            int number;
            try {
                line = r.readLine();
                number = Integer.parseInt(line);
            } catch (Exception ignore) {
                continue;
            }
            set.add(number);
        } while(r.ready());

        for (Integer i : set) {
            System.out.println(i);
        }
    }
}
