package a2023_04.photos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Photos {

    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String line;

        int w = Integer.parseInt(r.readLine());
        String[] numbers = r.readLine().trim().split(" ");
        int n = Integer.parseInt(numbers[0]);
        int k = Integer.parseInt(numbers[1]);

        ArrayList<Integer> heights = new ArrayList<>();

        do {
            line = r.readLine();
            String[] split = line.trim().split("x");
            heights.add(normalize(Integer.parseInt(split[0]), Integer.parseInt(split[1]), w));
        } while (r.ready());

        heights.sort(Integer::compareTo);
        int min = 0;
        int max = 0;
        for (int i = 0; i < k; i++) {
            min += heights.get(i);
            max += heights.get(heights.size()-1-i);
        }
        System.out.println(min);
        System.out.println(max);
    }

    static int normalize(int w, int h, int newW) {
        return (int)(Math.ceil(((double) h * newW) / w));
    }
}
