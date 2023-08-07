package a2023_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Brackets_ {

    private final int length;

    Brackets_(int length) {
        this.length = length;
    }

    public static void main(String[] args) throws IOException  {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(r.readLine());

        new Brackets_(number * 2).addBracket("", 0, 0);
    }

    void addBracket(String string, int open, int closed) {
        if (string.length() == length && open == closed) {
            System.out.println(string);
            return;
        }

        if (open < length / 2) {
            addBracket(string + "(", open + 1, closed);
        }

        if (closed < open) {
            addBracket(string + ")", open, closed + 1);
        }
    }
}
