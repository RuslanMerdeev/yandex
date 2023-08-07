package a2023_08;

import utils.Caterpillar;

class LongestUnrepeatable extends Caterpillar {

    public boolean getCondition(String substring) {
        boolean result = true;
        for (int i = 0; i < substring.length(); i++) {
            if (substring.substring(i+1).contains(String.valueOf(substring.charAt(i)))) {
                result = false;
                break;
            }
        }

        return result;
    }

    public int getResult(String substring, int result) {
        return Math.max(substring.length(), result);
    }

    public static void main(String[] args) {
        LongestUnrepeatable longestUnrepeatable = new LongestUnrepeatable();
        int result = longestUnrepeatable.countLongest("1112");
        System.out.println(result);
    }
}
