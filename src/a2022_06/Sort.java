package a2022_06;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Sort {

    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String line = r.readLine();
        int number = Integer.parseInt(line);
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int b;
        int e;
        boolean error;

        for (long i = 0; i < Math.pow(2,((number*2)-1)); i++) {
            System.out.println(i);
            sb.setLength(0);
            b = 0;
            e = 0;
            error = false;
            for (int j = 0; j < number*2; j++) {
                if ((i & 1L<<j) == 0) {
                    if (b >= number) {
                        error = true;
                        break;
                    }
                    sb.append("(");
                    b++;
                } else {
                    if (e >= b || e >= number) {
                        error = true;
                        break;
                    }
                    sb.append(")");
                    e++;
                }
            }
            if (!error) {
                list.add(sb.toString());
            }
        }

        list = list.stream().sorted().collect(Collectors.toList());

        for (String str : list) {
            System.out.println(str);
        }
    }
}
