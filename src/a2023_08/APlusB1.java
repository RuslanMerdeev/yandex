package a2023_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class APlusB1 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = reader.readLine().split(" ");
        Integer sum = Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]);
        System.out.println(sum);
    }
}
