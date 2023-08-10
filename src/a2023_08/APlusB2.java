package a2023_08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class APlusB2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        String[] numbers = reader.readLine().split(" ");
        Integer sum = Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]);
        writer.write(sum.toString());
        writer.newLine();
        writer.flush();
    }
}
