package a2022_06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Ana {

    public void addToDict(Map<Character, Integer> dict, Character character) {
        Integer number = dict.get(character);
        if (number == null) {
            number = 1;
        }
        number++;
        dict.put(character, number);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        Map<Character, Integer> first = new HashMap<>();
        Map<Character, Integer> second = new HashMap<>();
        Ana ana = new Ana();

        int character = r.read();

        while (character != '\n') {
            ana.addToDict(first, (char)character);
            character = r.read();
        }

        character = r.read();

        while (character != '\n') {
            ana.addToDict(second, (char)character);
            character = r.read();
        }

        System.out.println(first.equals(second) ? 1 : 0);
    }
}
