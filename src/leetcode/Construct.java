package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Construct {
    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            Map<Character, Integer> dict = toDict(magazine);
            boolean can = true;
            for (int i = 0; i < ransomNote.length(); i++) {
                if(!takeFromDict(dict, ransomNote.charAt(i))) {
                    can = false;
                    break;
                }
            }
            return can;
        }

        Map<Character, Integer> toDict(String str) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                Character character = str.charAt(i);
                Integer number = map.get(character);
                if (number == null) {
                    number = 0;
                }
                number++;
                map.put(character, number);
            }
            return map;
        }

        boolean takeFromDict(Map<Character, Integer> dict, Character character) {
            Integer number = dict.get(character);
            if (number == null || number == 0) {
                return false;
            }
            number--;
            dict.put(character, number);
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Construct().new Solution();
        boolean canConstruct = solution.canConstruct("ab", "");
        System.out.println(canConstruct);
    }
}
