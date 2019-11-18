package leetcode.common;

public class MallUtil {
    public static void main(String[] args) {
        String malls = "134434236\n" +
                "374061017\n" +
                "514571399\n" +
                "853094388\n" +
                "995722367\n" +
                "125663597\n" +
                "137413776\n" +
                "726117261\n" +
                "543208280\n" +
                "875054784\n" +
                "268528206\n" +
                "233221091\n" +
                "603355\n" +
                "641";
        String[] mallSplits = malls.split("\n");
        for (String mid : mallSplits) {
            System.out.print(mid + ",");
        }

    }
}
