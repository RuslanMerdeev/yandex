package a2022_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Ones {

    int longestOnes(List<String> string) {
        int result = 0;
        int max = 0;
        for (String item : string) {
            if (item.equals("1")) {
                max++;
            } else {
                result = Math.max(max, result);
                max = 0;
            }
        }
        return Math.max(max, result);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        r.readLine();

        do {
            list.add(r.readLine());
        } while(r.ready());

        int ones = new Ones().longestOnes(list);

        System.out.println(ones);
    }
}
