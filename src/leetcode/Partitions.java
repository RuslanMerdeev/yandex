package leetcode;
// https://leetcode.com/problems/partition-labels/description/

// "abc" -> [1,1,1]
// "aabbcc" -> [2,2,2]
// "abbcca" -> [6]
// "aaa" -> [3]
// "abcabcabc" -> [7,1,1]
// "a" -> [1]
// "" -> []


import java.util.ArrayList;
import java.util.List;

public class Partitions {

    class Solution {

        List<Integer> resolve(String s) {
            ArrayList<Integer> result = new ArrayList<>();
            if (s.isEmpty()) {}
            else if (s.length() == 1) {
                result.add(1);
            } else {
                int i = 0;
                do {
                    int j = s.length() - 1;
                    for (; j > i; j--) {
                        if (s.charAt(i) == s.charAt(j)) {
                            result.add(j - i + 1);
                            i = j + 1;
                            break;
                        }
                    }
                    if (j == i) {
                        result.add(1);
                        i++;
                    }
                } while (i < s.length());
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Partitions().new Solution();
        String s = "ababcbacadefegdehijhklij";
        List<Integer> parts = solution.resolve(s);
        System.out.println(parts);
    }
}
