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
            Map<Character, Integer> slide = createMap(s2.substring(0, s1Length));

            // 3,4 -> 0,1
            int pos = 0;
            do {
                if (slide.equals(template)) return true;
                if (pos<s2Length-s1Length) updateMap(slide, s2.charAt(pos), s2.charAt(pos+s1Length));
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

        void updateMap(Map<Character, Integer> map, Character remove, Character add) {
            if (!remove.equals(add)) {
                Integer removeNumber = map.get(remove);
                Integer addNumber = map.get(add);
                removeNumber--;
                if (removeNumber == 0) {
                    map.remove(remove);
                } else {
                    map.put(remove, removeNumber);
                }
                if (addNumber == null) {
                    addNumber = 0;
                }
                addNumber++;
                map.put(add, addNumber);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Permutation().new Solution();
        String first = "abc";
        String second = "cccccbabbbaaaa";
        boolean result = solution.checkInclusion(first, second);
        System.out.println(result);
    }
}
