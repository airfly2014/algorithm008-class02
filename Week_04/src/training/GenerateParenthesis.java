package training;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/#/description
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class GenerateParenthesis {


    public static void main(String[] args) {

        GenerateParenthesis parenthesis = new GenerateParenthesis();
        parenthesis.generateParenthesis(1);
    }

//    public List<String> generateParenthesis(int n) {
//
//        ArrayList<String> resutls = new ArrayList<>();
//
//
//        generateParenthesis(0,0,n,"",resutls);
//        return resutls;
//    }
//
//    private void generateParenthesis(int left, int right, int max, String str,
// ArrayList<String> resutls) {
//
//        if(left == max && right == max){
//            resutls.add(str);
//            return;
//        }
//
//
//        if(left < max){
//            generateParenthesis(left + 1, right, max, str + "(", resutls);
//        }
//
//        if(right < left){
//            generateParenthesis(left , right + 1, max, str + ")", resutls);
//        }
//    }


    class Node {
        String str;
        int left;
        int right;

        public Node(String str, int left, int right) {
            this.str = str;
            this.left = left;
            this.right = right;
        }
    }

    public List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>();
        LinkedList<Node> stack = new LinkedList<>();

        stack.add(new Node("",0,0));

        while (!stack.isEmpty()){
            Node node = stack.poll();
            if(node.left == n && node.right == n){
                result.add(node.str);
                continue;
            }

            if(node.left < n){
                stack.add(new Node(node.str + "(", node.left + 1, node.right));
            }

            if(node.right <  node.left){
                stack.add(new Node(node.str + ")", node.left, node.right + 1));

            }
        }
        return result;
    }

}
