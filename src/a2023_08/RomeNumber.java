package a2023_08;

import java.util.LinkedHashMap;
import java.util.Map;

// I - 1
// V - 5
// X - 10
// L - 50
// C - 100
// D - 500
// M - 1000

// I - 1
// IV - 4
// V - 5
// IX - 9
// X - 10
// XL - 40
// L - 50
// XC - 90
// C - 100
// CD - 400
// D - 500
// CM - 900
// M - 1000

public class RomeNumber {

    private final LinkedHashMap<String, Integer> DIGITS = new LinkedHashMap() {{
        put("M", 1000);
        put("CM", 900);
        put("D", 500);
        put("CD", 400);
        put("C", 100);
        put("XC", 90);
        put("L", 50);
        put("XL", 40);
        put("X", 10);
        put("IX", 9);
        put("V", 5);
        put("IV", 4);
        put("I", 1);
    }};

    public String toRome(int number) {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, Integer> entry : DIGITS.entrySet()) {
            while (number >= entry.getValue()) {
                result.append(entry.getKey());
                number -= entry.getValue();
            }
            if (number == 0) {
                break;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        RomeNumber romeNumber = new RomeNumber();
        String result = romeNumber.toRome(1444);
        System.out.println(result);
    }
}
