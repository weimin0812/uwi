package question028;

public class Solution {
    // haystack = "hello", needle = "ll"
    public static void main(String[] args) {
        Solution solution = new Solution();
        String haystack = "a", needle = "a";
        System.out.println(solution.strStr(haystack, needle));
        haystack.indexOf(needle);
    }

    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }

        int index = 0;
        for (int i = 0; i < haystack.length(); ) {
            if (needle.charAt(index) == haystack.charAt(i)) {
                index++;
                i++;
            } else {
                i = i - index + 1;
                index = 0;
            }

            if (index == needle.length()) {
                return i - index;
            }
        }

        return -1;
    }

}
