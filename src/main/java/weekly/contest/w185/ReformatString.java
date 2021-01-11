package weekly.contest.w185;

public class ReformatString {
    public static void main(String[] args) {
        String s = "a0b1c";
        ReformatString reformatString = new ReformatString();
        String reformat = reformatString.reformat(s);
        System.out.println(reformat);
    }

    public String reformat(String s) {
        StringBuilder alpha = new StringBuilder();
        StringBuilder digits = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                digits.append(c);
            } else {
                alpha.append(c);
            }
        }
        StringBuilder ret = new StringBuilder();
        if (Math.abs(digits.length() - alpha.length()) > 1) {
            return ret.toString();
        }
        int i = 0, j = 0;
        int index = 0;
        StringBuilder longer = alpha.length() >= digits.length() ? alpha : digits;
        StringBuilder shorter = alpha.length() >= digits.length() ? digits : alpha;
        while (i < longer.length() || j < shorter.length()) {
            if (index % 2 == 0) {
                ret.append(longer.charAt(i));
                i++;
            } else {
                ret.append(shorter.charAt(j));
                j++;
            }
            index++;
        }
        return ret.toString();
    }
}
