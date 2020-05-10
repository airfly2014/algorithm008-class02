package training;

import java.util.LinkedList;
import java.util.Queue;

import javafx.util.Pair;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/submissions/
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 */
public class MaxDepth {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public int maxDepth(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        if (root != null) {
            stack.add(new Pair(root, 1));
        }

        int depth = 0;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.poll();
            root = current.getKey();
            int current_depth = current.getValue();
            if (root != null) {
                depth = Math.max(depth, current_depth);
                stack.add(new Pair(root.left, current_depth + 1));
                stack.add(new Pair(root.right, current_depth + 1));
            }
        }
        return depth;
    }


//    public int maxDepth(TreeNode root) {
//
//        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();
//        if(root == null){
//            return 0;
//        }
//        Pair<TreeNode, Integer> pair = new Pair<>(root, 1);
//        queue.add(pair);
//        int currentLength = 1;
//        while (!queue.isEmpty()){
//            Pair<TreeNode, Integer> currentPair = queue.poll();
//            root = currentPair.getKey();
//            Integer length = currentPair.getValue();
//            if(root == null) continue;
//            currentLength = Math.max(currentLength, length);
//            queue.push(new Pair<>(root.left, length + 1));
//            queue.push(new Pair<>(root.right, length + 1));
//
//        }
//
//        return currentLength;
//    }
}
