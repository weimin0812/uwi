package leetcode.common;

public class TestFinally {
    public static void main(String[] args) {
        try {
            int num = Integer.parseInt("gash");
        } finally {
            System.out.println("finally");
        }
    }
}
