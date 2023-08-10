package leetcode;

public class Subsequence {

    class Solution {
        public boolean isSubsequence(String s, String t) {
            return isSubsequence(s, 0, t, 0);
        }

        boolean isSubsequence(String s, int posS, String t, int posT) {
            int lengthS = s.length() - posS;
            int lengthT = t.length() - posT;
            if (lengthS == 0) {
                return true;
            }
            if (lengthT < lengthS || lengthT == 0) {
                return false;
            }
            boolean same = false;
            for (int i = posT; i < t.length(); i++) {
                if (s.charAt(posS) == t.charAt(i) && isSubsequence(s, posS + 1, t, i + 1)) {
                    same = true;
                    break;
                }
            }
            return same;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Subsequence().new Solution();
        boolean subsequence = solution.isSubsequence("sdlfkjasklfsjdfklsjdfkls", "");
        System.out.println(subsequence);
    }
}
