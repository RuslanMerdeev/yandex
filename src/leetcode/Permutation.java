package leetcode;
// https://leetcode.com/problems/permutation-in-string/

// "" and "" -> false
// "a" and "" -> false
// "" and "a" -> false
// "a" and "aa" -> true
// "ab" and "ab" -> true
// "abc" and "ab" -> true
// "abc" and "abcaabca" -> true

import java.util.HashMap;
import java.util.Map;

public class Permutation {

    class Solution {

        public boolean checkInclusion(String s1, String s2) {
            int s1Length = s1.length();
            int s2Length = s2.length();
            if (s1Length == 0 || s1Length > s2Length) return false;

            Map<Character, Integer> template = createMap(s1);
            Map<Character, Integer> slide;

            // 2,4 -> 0,1,2
            int pos = 0;
            do {
                //2,6 -> 0,1,2,3,4 ; 1,2,3,4,5
                slide = createMap(s2.substring(pos, pos+s1Length));
                if (slide.equals(template)) return true;
                pos++;
            } while (pos <= s2Length-s1Length);
            return false;
        }

        Map<Character, Integer> createMap(String s) {
            Map<Character, Integer> map = new HashMap<>();
            for (Character c : s.toCharArray()) {
                map.merge(c, 1, Integer::sum);
            }
            return map;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Permutation().new Solution();
        String first = "";
        String second = "cbaebabacd";
        boolean result = solution.checkInclusion(first, second);
        System.out.println(result);
    }
}
