package a2022_06;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ham {

    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String line;

        r.readLine();

        do {
            line = r.readLine();
            line = line.replaceAll("[^-0-9]+", " ");
            String[] numbers = line.trim().split(" ");
            int first = Integer.parseInt(new StringBuilder(numbers[0]).reverse().toString(), 2);
            int second = Integer.parseInt(new StringBuilder(numbers[1]).reverse().toString(), 2);
            System.out.println(first + " " + second);
            int hammingDistance = hammingDistance(first, second);
            System.out.println(hammingDistance);
            String result = Integer.toBinaryString(hammingDistance);
            System.out.println(result);
        } while (r.ready());
    }

    private static int hammingDistance(int x, int y)
    {
        int num=x^y;
        int ct=0;
        while(num!=0)
        {
            num=num&(num-1);
            ct++;
        }
        return ct;
    }

    private static int hammingDistance1(int x, int y) {
        int t = x^y;
        int ans=0;
        while(t>0){
            ans+=1;
            t = t&(t-1);
        }
        return ans;
    }
}
