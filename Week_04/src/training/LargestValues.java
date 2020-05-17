package training;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/#/description
 * 515. 在每个树行中找最大值
 * 您需要在二叉树的每一行中找到最大的值。
 * <p>
 * 示例：
 * <p>
 * 输入:
 * <p>
 * 1
 * / \
 * 3   2
 * / \   \
 * 5   3   9
 * <p>
 * 输出: [1, 3, 9]
 */
public class LargestValues {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

//    public List<Integer> largestValues(TreeNode root) {
//        ArrayList<Integer> result = new ArrayList<>();
//        if(root == null){
//            return result;
//        }
//        LinkedList<TreeNode> stack = new LinkedList<>();
//        stack.push(root);
//
//        while (!stack.isEmpty()){
//            int size = stack.size();
//            int max = Integer.MIN_VALUE;
//            for(int i = 0; i < size; i++){
//                TreeNode node = stack.poll();
//                max = Math.max(max, node.val);
//                if(node.left != null){
//                    stack.add(node.left);
//                }
//
//                if(node.right != null){
//                    stack.add(node.right);
//                }
//            }
//            result.add(max);
//
//        }
//
//        return result;
//    }

    public List<Integer> largestValues(TreeNode root) {

        ArrayList<Integer> result = new ArrayList<>();
        largestValues(root, 0 ,result);

        return result;

    }

    private void largestValues(TreeNode node, int level, ArrayList<Integer> result) {

        if(node == null){
            return;
        }

        if(level == result.size()){
            result.add(node.val);
        }else{
            result.set(level, Math.max(result.get(level), node.val));
        }

        largestValues(node.left, level + 1, result);
        largestValues(node.right, level + 1, result);
    }

}
