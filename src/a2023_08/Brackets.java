package a2023_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Brackets {

    private final int length;

    Brackets(int length) {
        this.length = length;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(r.readLine());

        new Brackets(number).addBracket("", 0, 0);
    }

    void addBracket(String string, int open, int closed) {
        if (string.length() == length * 2) {
            System.out.println(string);
            return;
        }

        if (open < length) {
            addBracket(string + "(", open + 1, closed);
        }

        if (closed < open) {
            addBracket(string + ")", open, closed + 1);
        }
    }
}
