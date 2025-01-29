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
                int pos = 0;
                do {
                    int j = s.length() - 1;
                    for (; j > i; j--) {
                        if (s.charAt(i) == s.charAt(j)) {
                            if (i < pos && j > pos) {
                                int last = result.size() - 1;
                                Integer lastValue = result.get(last);
                                Integer newValue = lastValue + j - pos;
                                result.set(last, newValue);
                                pos = j;
                            } else {
                                int toAdd = j - i + 1;
                                result.add(toAdd);
                                pos += toAdd;
                            }
                            break;
                        }
                    }
                    if (j == i) {
                        result.add(1);
                        pos++;
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
