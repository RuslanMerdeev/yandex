package a2023_04.accounts;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Accounts {

    static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
    static String YEAR = ".2022";
    static String[] QUARTERS_FROM = {"01.01"+YEAR, "01.04"+YEAR, "01.07"+YEAR, "01.10"+YEAR, "01.01.2023"};

    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String line;
        Double[] quarters = {0d,0d,0d,0d};

        r.readLine();

        do {
            line = r.readLine();
            String[] split = line.trim().split(" ");
            int amount = Integer.parseInt(split[0]);
            String from = split[1]+YEAR;
            String to = plusDays(split[2]+YEAR, 1);
            double perDay = (double)(amount*100 /daysBetween(from, to))/100;
            for (int i = 0; i < 4; i++) {
                quarters[i] = quarters[i] + perDay*daysBetween(
                        get(from, QUARTERS_FROM[i], QUARTERS_FROM[i+1]),
                        get(to, QUARTERS_FROM[i], QUARTERS_FROM[i+1])
                );
            }
        } while (r.ready());

        Arrays.stream(quarters).forEach(quarter -> {
            System.out.println(String.format("%.2f" , quarter).replaceAll(",", "."));
        });
    }

    static long daysBetween(String from, String to) throws Exception {

        Date firstDate = sdf.parse(from);
        Date secondDate = sdf.parse(to);
        long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
        return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }

    static String plusDays(String date, int days) throws Exception {
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(date));
        c.add(Calendar.DATE, days);
        return sdf.format(c.getTime());
    }

    static Boolean before(String first, String second) throws Exception {
        return sdf.parse(first).before(sdf.parse(second));
    }

    static String get(String date, String from, String to) throws Exception {
        if (before(date,from)) return from;
        else if (before(to, date)) return to;
        return date;
    }
}
