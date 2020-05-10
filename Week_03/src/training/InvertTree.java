package training;

import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/invert-binary-tree/solution/fan-zhuan-er-cha-shu-by-leetcode/
 * 226. 翻转二叉树
 * 翻转一棵二叉树。
 * <p>
 * 示例：
 * <p>
 * 输入
 */
public class InvertTree {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


//    public TreeNode invertTree(TreeNode root) {
//
//        if (root == null) {
//            return root;
//        }
//
//        TreeNode left = invertTree(root.left);
//        TreeNode right = invertTree(root.right);
//        root.left = right;
//        root.right = left;
//        return root;
//    }

    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return root;
        }

        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.push(root);
        while (!treeNodes.isEmpty()){
            TreeNode top = treeNodes.poll();
            TreeNode left = top.left;
            TreeNode right = top.right;
            top.left = right;
            top.right =left;

            if(top.left != null) treeNodes.push(top.left);
            if(top.right != null) treeNodes.push(top.right);
        }

        return root;
    }
}
