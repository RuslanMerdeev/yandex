package a2022_06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ana_ {

    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String line1 = r.readLine();
        String line2 = r.readLine();

        int line1Length = line1.length();
        int line2Length = line2.length();

        if (line1Length != line2Length || line1Length == 0) {
            System.out.println(0);
            return;
        }

        List<String> chars1 = Arrays.stream(line1.split("")).sorted().collect(Collectors.toList());
        List<String> chars2 = Arrays.stream(line2.split("")).sorted().collect(Collectors.toList());

        System.out.println(chars1.equals(chars2) ? 1 : 0);
    }
}