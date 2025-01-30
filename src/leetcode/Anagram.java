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
            Map<Character, Integer> str = createMap(s.substring(0,pLen));

            // 2,2 -> 0
            // 3,2 -> 0,1
            // 4,2 -> 0,1,2
            for (int i = 0; i <= sLen-pLen; i++) {

                if(template.equals(str)) {
                    result.add(i);
                }

                // 4,2 -> 0,1 -> 0x 2v
                if(i< sLen-pLen) {
                    updateMap(str, s.charAt(i), s.charAt(i+pLen));
                }
            }
            return result;
        }

        Map<Character, Integer> createMap(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (char c : s.toCharArray()) {
                map.merge(c, 1, Integer::sum);
            }
            return map;
        }

        void updateMap(Map<Character, Integer> map, Character remove, Character add) {
            if (!remove.equals(add)) {
                Integer addNumber = map.get(add);
                if (addNumber == null) {
                    addNumber = 0;
                }
                map.put(add, addNumber +1);
                Integer removeNumber = map.get(remove);
                if (removeNumber == 1) {
                    map.remove(remove);
                } else {
                    map.put(remove, removeNumber - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Anagram().new Solution();
        String first = "cbaebabacd";
        String second = "abc";
        List<Integer> result = solution.findAnagrams(first, second);
        System.out.println(result);
    }
}
