package training;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/submissions/
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

    public List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>();
        generateParenthesis(0, 0, n, "", result);
        return result;
    }

    private void generateParenthesis(int left, int right, int max, String str, List<String>
            result) {
        if (left == max && right == max) {
            result.add(str);
            return;
        }

        if (left < max) {
            generateParenthesis(left + 1, right, max, str + "(", result);
        }

        if(left > right){
            generateParenthesis(left, right + 1, max, str + ")", result);
        }
    }


}
