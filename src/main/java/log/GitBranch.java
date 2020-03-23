package log;

public class GitBranch {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("git branch -D");
        String branches = " shenxiu-ORC-205\n" +
                "  shenxiu-ORC-400\n" +
                "  shenxiu-ORC-448\n" +
                "  shenxiu-ORC-450\n" +
                "  shenxiu-ORC-455";
        String[] split = branches.split("\n");
        for (String s : split) {
            sb.append(" ").append(s);
        }
        System.out.println(sb.toString());
    }
}
