package leetcode;

public class Palindrome {
    class Solution {
        public boolean isPalindrome(String s) {
            s = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
            StringBuilder reverse = new StringBuilder(s);
            reverse.reverse();
            return s.equals(reverse.toString());
        }
    }

    public static void main(String[] args) {
        Solution solution = new Palindrome().new Solution();
        boolean palindrome = solution.isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(palindrome);
    }
}
