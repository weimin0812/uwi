package leetcode.common;

import java.util.List;
import java.util.stream.Collectors;

public abstract class TreeUtil {
    public static TreeNode toTree(List<String> levelOrders) {
        if (levelOrders == null || levelOrders.isEmpty()) {
            return null;
        }
        List<TreeNode> nodes = levelOrders.stream().map(s -> "#".equals(s) ? null : new TreeNode(Integer.parseInt(s))).collect(Collectors.toList());
        for (int i = 0, j = 1; i < nodes.size(); i++) {
            if (nodes.get(i) != null) {
                nodes.get(i).left = nodes.get(j++);
                nodes.get(i).right = nodes.get(j++);
            }
        }
        return nodes.get(0);
    }
}
