//Serialization is the process of converting a data structure or object into a s
//equence of bits so that it can be stored in a file or memory buffer, or transmit
//ted across a network connection link to be reconstructed later in the same or an
//other computer environment. 
//
// Design an algorithm to serialize and deserialize a binary tree. There is no r
//estriction on how your serialization/deserialization algorithm should work. You 
//just need to ensure that a binary tree can be serialized to a string and this st
//ring can be deserialized to the original tree structure. 
//
// Example: 
//
// 
//You may serialize the following tree:
//
//    1
//   / \
//  2   3
//     / \
//    4   5
//
//as "[1,2,3,null,null,4,5]"
// 
//
// Clarification: The above format is the same as how LeetCode serializes a bina
//ry tree. You do not necessarily need to follow this format, so please be creativ
//e and come up with different approaches yourself. 
//
// Note: Do not use class member/global/static variables to store states. Your s
//erialize and deserialize algorithms should be stateless. 
// Related Topics Tree Design

package leetcode.editor.en;

import leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {

    public static void main(String[] args) {

    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuffer sb = new StringBuffer();
            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode current = root;
            queue.offer(current);
            while (!queue.isEmpty()) {
                current = queue.poll();
                if (current == null) {
                    sb.append("null");
                } else {
                    sb.append(current.val);
                }
                sb.append("#");
                if (current != null) {
                    queue.offer(current.left);
                    queue.offer(current.right);
                }
            }
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] vals = data.split("#");
            TreeNode[] nodes = new TreeNode[vals.length];
            for (int i = 0; i < nodes.length; i++) {
                if (!"null".equals(vals[i])) {
                    nodes[i] = new TreeNode(Integer.parseInt(vals[i]));
                }
            }
            for (int i = 0, j = 1; j < nodes.length; i++) {
                if (nodes[i] != null) {
                    nodes[i].left = nodes[j++];
                    nodes[i].right = nodes[j++];
                }
            }
            return nodes[0];
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}
