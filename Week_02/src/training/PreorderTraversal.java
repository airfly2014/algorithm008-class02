package training;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * <p>
 * 144. 二叉树的前序遍历
 * 给定一个二叉树，返回它的 前序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class PreorderTraversal {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {


        ArrayList<Integer> list = new ArrayList<>();
        traversal(root, list);
        return list;
    }


    private void traversal(TreeNode node, List<Integer> list){
        if(node == null){
            return;
        }

        list.add(node.val);
        if(node.left != null){
            traversal(node.left, list);
        }

        if(node.right != null){
            traversal(node.right, list);
        }
    }


    public List<Integer> preorderTraversal2(TreeNode root) {


        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(cur == null){
                continue;
            }
            list.add(cur.val);
            if(cur.right != null){
                stack.push(cur.right);
            }

            if(cur.left != null){
                stack.push(cur.left);
            }
        }

        return list;
    }


    public List<Integer> preorderTraversal3(InorderTraversal.TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Deque<InorderTraversal.TreeNode> stack = new LinkedList<>();
        InorderTraversal.TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                result.add(node.val);
                stack.push(node.right);
                node = node.left;
            } else {
                node = stack.pop();
            }
        }
        return result;
    }
}
