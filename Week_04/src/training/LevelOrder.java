package training;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/#/description
 * 102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * <p>
 * 二叉树：[3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LevelOrder {


    public static void main(String[] args) {

        LevelOrder levelOrder = new LevelOrder();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        levelOrder.levelOrder(treeNode1);
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
//
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
//        ArrayList<List<Integer>> result = new ArrayList<>();
//
//        levelOrder(root,hashMap,0);
//
//        result.addAll(hashMap.values());
//        return result;
//    }
//
//    private void levelOrder(TreeNode node, HashMap<Integer, List<Integer>> hashMap, int level) {
//
//        if(node == null){
//            return;
//        }
//
//        List<Integer> levelData = hashMap.getOrDefault(level, new ArrayList<Integer>());
//        levelData.add(node.val);
//        hashMap.put(level, levelData);
//        levelOrder(node.left, hashMap,level + 1);
//        levelOrder(node.right, hashMap,level + 1);
//    }





    public List<List<Integer>> levelOrder(TreeNode root) {

        ArrayList<List<Integer>> result = new ArrayList<>();
        List<TreeNode> levelNodes = new LinkedList<>();
        if (root == null) {
            return result;
        }
        levelNodes.add(root);

        while (!levelNodes.isEmpty()) {
            int size = levelNodes.size();
            ArrayList<Integer> levelValue = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = levelNodes.remove(0);
                levelValue.add(node.val);

                if (node.left != null) {
                    levelNodes.add(node.left);
                }
                if (node.right != null) {
                    levelNodes.add(node.right);
                }
            }
            result.add(levelValue);
        }
        return result;
    }

//    vector<vector<int>> levelOrder(TreeNode* root) {
//        vector <vector <int>> ret;
//        if (!root) return ret;
//
//        queue <TreeNode*> q;
//        q.push(root);
//        while (!q.empty()) {
//            int currentLevelSize = q.size();
//            ret.push_back(vector <int> ());
//            for (int i = 1; i <= currentLevelSize; ++i) {
//                auto node = q.front(); q.pop();
//                ret.back().push_back(node->val);
//                if (node->left) q.push(node->left);
//                if (node->right) q.push(node->right);
//            }
//        }
//
//        return ret;
//    }

}

