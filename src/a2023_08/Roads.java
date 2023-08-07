package a2023_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Roads {
    List<List<Integer>> coordinates = new ArrayList<>();

    public int further(List<Integer> where, List<Integer> to, int max, int driven) {
        if (where.equals(to)) {
            return driven;
        }

        int distance = distance(where, to);
        int minDriven = Integer.MAX_VALUE;

        for (List<Integer> coordinate : coordinates) {
            int dTo = distance(coordinate, to);
            int dWhere = distance(where, coordinate);
            if (dTo < distance && dWhere <= max) {
                minDriven = Math.min(minDriven, further(coordinate, to, max, driven + 1));
            }
        }

        return minDriven;
    }

    public int distance(List<Integer> from, List<Integer> to) {
        return Math.abs(to.get(0) - from.get(0)) + Math.abs(to.get(1) - from.get(1));
    }

    public static void main (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(reader.readLine());
        Roads roads = new Roads();

        for(int i = 0; i < number; i++) {
            String[] point = reader.readLine().split(" ");
            roads.coordinates.add(new ArrayList<>() {{
                add(Integer.parseInt(point[0]));
                add(Integer.parseInt(point[1]));
            }});
        }

        int max = Integer.parseInt(reader.readLine());
        String[] cities = reader.readLine().split(" ");
        int driven = roads.further(
                roads.coordinates.get(Integer.parseInt(cities[0])-1),
                roads.coordinates.get(Integer.parseInt(cities[1])-1),
                max,
                0
        );
        if (driven == Integer.MAX_VALUE) {
            driven = -1;
        }
        System.out.println(driven);
    }
}
