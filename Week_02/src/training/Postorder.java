package training;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


/**
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 * 590. N叉树的后序遍历
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 * <p>
 * <p>
 * 返回其后序遍历: [5,6,3,2,4,1].
 * <p>
 * <p>
 * <p>
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 */
public class Postorder {


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





    public List<Integer> postorder(Node root) {

        LinkedList<Integer> list = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        if(root == null){
            return  list;
        }

        stack.push(root);
        while (!stack.isEmpty()){
            Node pop = stack.pop();
            list.addFirst(pop.val);

            for(Node node : pop.children){
                if(node != null){
                    stack.push(node);
                }
            }
        }

        return list;
    }


}
