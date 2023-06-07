package a2022_06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Ana {

    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String line1 = r.readLine();
        String line2 = r.readLine();
        List<Character> chars1 = new ArrayList<>();
        List<Character> chars2 = new ArrayList<>();

        for (char ch : line1.toCharArray()) {
            chars1.add(ch);
        }

        for (char ch : line2.toCharArray()) {
            chars2.add(ch);
        }

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        chars1 = chars1.stream().sorted().collect(Collectors.toList());
        chars2 = chars2.stream().sorted().collect(Collectors.toList());

        for (Character ch : chars1) {
            sb1.append(ch);
        }

        for (Character ch : chars2) {
            sb2.append(ch);
        }

        System.out.println(sb1.toString().equals(sb2.toString()) ? 1 : 0);
    }
}
