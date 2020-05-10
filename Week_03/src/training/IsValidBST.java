package training;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * 题目描述
 * 评论 (600)
 * 题解(446)
 * 提交记录
 * 98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class IsValidBST {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    private boolean result = true;
    private List<TreeNode> list = new ArrayList<>();

//    public boolean isValidBST(TreeNode root) {
//
//
//        inOrder(root);
//        return result;
//    }

    public void inOrder(TreeNode root) {

        if (root == null) {
            return;
        }


        inOrder(root.left);
        if (list.size() > 0) {
            TreeNode treeNode = list.get(list.size() - 1);
            if (root.val <= treeNode.val) {
                result = false;
            }
        }

        list.add(root);
        inOrder(root.right);
    }
//
//    public boolean isValidBST(TreeNode root) {
//
//        return helper(root, null, null);
//    }
//
//    private boolean helper(TreeNode root, Integer lower, Integer upper) {
//
//        if(root == null) return true;
//        if(lower != null && root.val <= lower) return false;
//        if(upper != null && root.val >= upper) return false;
//
//        if(!helper(root.left, lower, root.val)) return false;
//        if(!helper(root.right, root.val, upper)) return false;
//
//        return true;
//    }


//    LinkedList<Integer> uppers = new LinkedList<>();
//    LinkedList<Integer> lowers = new LinkedList<>();
//    Stack<TreeNode> stack = new Stack<>();
//
//
//    private void update(TreeNode node, Integer lower, Integer upper) {
//        stack.push(node);
//        uppers.push(upper);
//        lowers.push(lower);
//    }
//
//    public boolean isValidBST(TreeNode root) {
//
//        update(root, null, null);
//        Integer lower, upper;
//
//        while (!stack.isEmpty()) {
//            root = stack.pop();
//            upper = uppers.poll();
//            lower = lowers.poll();
//
//            if (root == null) continue;
//
//            if (lower != null && root.val <= lower) return false;
//            if (upper != null && root.val >= upper) return false;
//
//            update(root.left, lower, root.val);
//            update(root.right, root.val, upper);
//
//        }
//        return true;
//    }


//    public boolean isValidBST(TreeNode root) {
//
//        Stack<TreeNode> stack = new Stack<>();
//        Double inOrder = -Double.MAX_VALUE;
//
//        while (root != null || !stack.isEmpty()){
//            while (root != null){
//                stack.push(root);
//                root = root.left;
//            }
//
//            root = stack.pop();
//            if(root.val <= inOrder) return false;
//            inOrder = root.val;
//            root = root.right;
//        }
//
//        return true;
//
//    }



}
