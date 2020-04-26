package training;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/
 * <p>
 * 589. N叉树的前序遍历
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 * 返回其前序遍历: [1,3,5,6,2,4]。
 * <p>
 * <p>
 * <p>
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 */
public class Preorder {


    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }


    }

    public List<Integer> preorder(Node root) {

        LinkedList<Integer> list = new LinkedList<>();
        if(root == null){
            return  list;
        }
        order(root, list);
        return list;
    }


    private void order(Node node, List<Integer> list){
        if(node == null){
            return;
        }

        list.add(node.val);
        for(Node temp : node.children){
            order(temp,list);
        }
    }


    public List<Integer> preorder2(Node root) {

        LinkedList<Integer> output = new LinkedList<>();
        LinkedList<Node> stack = new LinkedList<>();

        if(root == null){
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()){
            Node top = stack.pollLast();
            output.add(top.val);
            Collections.reverse(top.children);
            for(Node node : top.children){
                stack.addLast(node);
            }
        }

        return output;
    }
}


