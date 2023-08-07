package a2023_08;

public class ReverseString {


    String reverse (String string) {
        int length = string.length();
        if (length == 1) {
            return string;
        }

        return reverse(string.substring(length/2)) + reverse(string.substring(0, length/2));
    }


    public static void main (String[] args) {
        System.out.println(new ReverseString().reverse("qwerty"));
    }
}
