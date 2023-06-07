package a2022_06;

import java.io.*;

public class Jewel {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        String j = r.readLine();
        String s = r.readLine();
        int result = 0;

        for (char c : s.toCharArray()) {
            if (j.indexOf(c) >= 0) {
                result++;
            }
        }

        System.out.println(result);
    }
}
