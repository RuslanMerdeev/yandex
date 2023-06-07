package a2022_06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Arith {

    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String line;

        r.readLine();

        Map<Integer, List<Integer>> map = new TreeMap<>();

        do {
            line = r.readLine();
            String[] numbers = line.trim().split(" ");
            int a1;
            int d;
            int id;

            switch (numbers[0]) {
                case "1":
                    a1 = Integer.parseInt(numbers[1]);
                    d = Integer.parseInt(numbers[2]);
                    id = Integer.parseInt(numbers[3]);
                    map.put(id, Arrays.asList(a1, d));
                break;

                case "2":
                    id = Integer.parseInt(numbers[1]);
                    map.remove(id);
                break;

                case "3":
                    System.out.println(find(map));
                break;
            }
        } while (r.ready());
    }

    private static Integer find(Map<Integer, List<Integer>> map) {
        Map.Entry<Integer, List<Integer>> integerListEntry = map.entrySet()
                .stream()
                .min(Comparator.comparing(key -> map.get(key.getKey()).get(0)))
                .orElse(null);

        if (integerListEntry != null) {
            List<Integer> result = map.get(integerListEntry.getKey());
            int res = result.get(0);
            result.set(0, result.get(0) + result.get(1));

            return res;
        }
        return 0;
    }
}
