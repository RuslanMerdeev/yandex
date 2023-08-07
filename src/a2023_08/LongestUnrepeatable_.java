package a2023_08;

class LongestUnrepeatable_ {

    int lengthOfUnrepeatableSubstring(String string) {
        if (string.length() < 2) return string.length();
        int left = 0;
        int length = 0;
        for (int right = 1; right < string.length(); right++) {
            while (containsRepeat(string.substring(left, right + 1)) && left < right) {
                left++;
            }
            length = Math.max(right + 1 - left, length);
        }

        return length;
    }

    boolean containsRepeat(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (string.substring(i + 1).contains(String.valueOf(string.charAt(i)))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LongestUnrepeatable_ longestUnrepeatable = new LongestUnrepeatable_();
        int length = longestUnrepeatable.lengthOfUnrepeatableSubstring("1234543210");
        System.out.println(length);
    }
}
