package training;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 * 429. N叉树的层序遍历
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 * <p>
 * 例如，给定一个 3叉树 :
 */


public class LevelOrder {


    // Definition for a Node.
   public static class Node {
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


    public List<List<Integer>> levelOrder(Node root) {

        ArrayList<List<Integer>> outputs = new ArrayList<>();
        if (root == null) {
            return outputs;
        }

        ArrayList<Node> currentLevel = new ArrayList();
        ArrayList<Integer> firstLevelValue = new ArrayList();
        currentLevel.add(root);
        firstLevelValue.add(root.val);
        outputs.add(firstLevelValue);

        boolean hasNextLevel = true;
        while (hasNextLevel) {

            hasNextLevel = false;

            ArrayList<Node> tempLevel = new ArrayList();
            ArrayList<Integer> tempVal = new ArrayList();

            for (Node node : currentLevel) {
                if (node.children != null) {
                    tempLevel.addAll(node.children);
                    for (Node child : node.children) {
                        if (child != null) {
                            hasNextLevel = true;
                            tempVal.add(child.val);
                        }
                    }
                }
            }


            currentLevel = tempLevel;
            if (hasNextLevel) {
                outputs.add(tempVal);
            }
        }
        return outputs;
    }


    public List<List<Integer>> levelOrder2(Node root) {

        List<List<Integer>> outputs = new ArrayList<>();
        if (root == null) {
            return outputs;
        }

       Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        while (nodes.size() > 0){
            int size = nodes.size();
            List<Integer> values = new ArrayList<>();
            for(int i = 0; i < size; i++){
                Node node = nodes.poll();
                values.add(node.val);
                if(node.children != null){
                    nodes.addAll(node.children);
                }
            }
            outputs.add(values);
        }

        return outputs;
    }


    public List<List<Integer>> levelOrder3(Node root) {

        List<List<Integer>> outputs = new ArrayList<>();
        if (root == null) {
            return outputs;
        }

        ArrayList<Node> preLayer = new ArrayList<>();
        preLayer.add(root);

        while (!preLayer.isEmpty()){
            ArrayList<Node> currentLayer = new ArrayList<>();
            ArrayList<Integer> preValue = new ArrayList<>();

            for(Node node : preLayer){
                preValue.add(node.val);
                currentLayer.addAll(node.children);
            }


            preLayer = currentLayer;
            if(!preValue.isEmpty()){
                outputs.add(preValue);
            }

        }

        return outputs;
    }
}
