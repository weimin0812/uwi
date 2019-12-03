package swordoffer.question44;

public class Solution {
    // “student. a am I” “I am a student.”。
    public String ReverseSentence(String str) {
        //todo str.trim()
        if (str == null || str.length() == 0 || "".equals(str.trim())) {
            return str;
        }
        String[] words = str.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
