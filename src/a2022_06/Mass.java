package a2022_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Mass {

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String line = r.readLine();

        line = line.replaceAll("[^-0-9]+", " ");
        String[] numbers = line.trim().split(" ");
        Map<Long, Integer> map = new HashMap<>();
        Long key;
        for (String number : numbers) {
            try {
                key = Long.parseLong(number);
            } catch (Exception ex) {
                continue;
            }
            Integer value = map.get(key);
            map.put(key, value != null ? value + 1 : 1);
        }

        List<Integer> collect = map.values().stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());

        int value = collect.get(0);

        List<Long> results = map.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == value)
                .map(Map.Entry::getKey)
                .sorted()
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        for (Long result : results) {
            sb.append(result);
            sb.append(" ");
        }
        System.out.println(sb);

    }
}
