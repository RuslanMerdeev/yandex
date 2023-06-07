package a2022_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class I10n {

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String line;

        r.readLine();

        Map<String, String> map = new LinkedHashMap<>();

        do {
            line = r.readLine();

            map.put(line, extracted(line,1));

        } while(r.ready());

        List<String> values = map.values()
                .stream()
                .filter(e -> Collections.frequency(map.values(), e) > 1)
                .collect(Collectors.toList());

        int factor = 2;
        while (!values.isEmpty()) {
            for (String key : map.keySet()) {
                if (values.contains(map.get(key))) {
                    map.put(key, extracted(key, factor));
                }
            }
            values = map.values()
                    .stream()
                    .filter(e -> Collections.frequency(map.values(), e) > 1)
                    .collect(Collectors.toList());
            factor++;
        }

        for (String key : map.keySet()) {
            System.out.println(map.get(key));
        }
    }

    private static String extracted(String line, int factor) {
        StringBuilder sb = new StringBuilder();
        if (line.length() >= factor*2) {
            sb.append(line, 0, factor);
            int i = line.length() - factor * 2;
            if (i > 0) {
                sb.append(i);
            }
            sb.append(line.substring(line.length() - factor));
        } else {
            sb.append(line);
        }
        return sb.toString();
    }
}
