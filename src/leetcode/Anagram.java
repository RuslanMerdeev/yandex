package leetcode;
// https://leetcode.com/problems/find-all-anagrams-in-a-string/description/

// "" and "" -> []
// "" and "a" -> []
// "a" and "" -> []
// "aa" and "a" -> [0,1]
// "ab" and "ab" -> [0]
// "ab" and "abc" -> []
// "abcaabca" and "abc" -> [0,1,4,5]

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagram {

    class Solution {

        public List<Integer> findAnagrams(String s, String p) {
            ArrayList<Integer> result = new ArrayList<>();
            int sLen = s.length();
            int pLen = p.length();

            if(pLen>sLen || pLen==0) {
                return result;
            }

            Map<Character, Integer> template = createMap(p);

            // 2,2 -> 0
            // 3,2 -> 0,1
            // 4,2 -> 0,1,2
            for (int i = 0; i <= sLen-pLen; i++) {
                if(template.equals(createMap(s.substring(i,i+pLen)))) {
                    result.add(i);
                }
            }
            return result;
        }

        Map<Character, Integer> createMap(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (char c : s.toCharArray()) {
                Integer number = map.get(c);
                if (number == null) {
                    number = 0;
                }
                number++;
                map.put(c, number);
            }
            return map;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Anagram().new Solution();
        String first = "abcaabca";
        String second = "abc";
        List<Integer> result = solution.findAnagrams(first, second);
        System.out.println(result);
    }
}
