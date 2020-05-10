package training;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/submissions/
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 */
public class LowestCommonAncestor {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


//    private TreeNode ans;
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//
//        helper(root, p, q);
//        return ans;
//    }
//
//    private boolean helper(TreeNode root, TreeNode p, TreeNode q) {
//
//        if(root == null){
//            return false;
//        }
//
//        boolean left = helper(root.left, p, q);
//        boolean right = helper(root.right, p, q);
//
//        boolean mid = root.val == p.val || root.val == q.val;
//        if(mid ? (left || right) : (left && right)){
//            ans = root;
//        }
//
//        return left || right || mid;
//    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        HashMap<TreeNode, TreeNode> hashMap = new HashMap<>();

        if(root == null){
            return null;
        }

        stack.push(root);
        hashMap.put(root, null);

        while (!hashMap.containsKey(p) || !hashMap.containsKey(q)){

            root = stack.poll();
            if(root.left != null){
                hashMap.put(root.left, root);
                stack.push(root.left);
            }
            if(root.right != null){
                hashMap.put(root.right, root);
                stack.push(root.right);
            }
        }

        HashSet<TreeNode> set = new HashSet<>();
        while (p != null){
            set.add(p);
            p = hashMap.get(p);
        }

        while (!set.contains(q)){
            q = hashMap.get(q);
        }

        return q;
    }


}
