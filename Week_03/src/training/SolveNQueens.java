package training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-queens/
 * 51. N皇后
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击
 */
public class SolveNQueens {


    public static void main(String[] args) {

        SolveNQueens solveNQueens = new SolveNQueens();
        List<List<String>> lists = solveNQueens.solveNQueens(3);
        System.out.println(lists.toString());
    }

    /**
     * 回溯大法好
     *
     * @param n
     * @return
     */

    public List<List<String>> solveNQueens(int n) {
        ArrayList<List<String>> result = new ArrayList<List<String>>();
        ArrayList<String> temp = new ArrayList<>();
        for(int i = 0; i < n; i++){
            char[] chars = new char[n];
            Arrays.fill(chars, '.');
            temp.add(new String(chars));
        }

        solveNQueens(result, temp, 0 , n);
        return result;
    }

    private void solveNQueens(ArrayList<List<String>> result, ArrayList<String> temp, int row, int n) {

        if(row == n){
            result.add(new ArrayList<>(temp));
            return;
        }


        for(int col = 0; col < n; col++){
            if(isVaild(temp , row , col, n)){
                String str = temp.get(row);
                char[] chars = str.toCharArray();
                chars[col] = 'Q';
                ArrayList<String> nextLine = new ArrayList<>();
                nextLine.addAll(temp);
                nextLine.set(row, new String(chars));
                solveNQueens(result, nextLine, row + 1, n);

            }
        }
    }

    private boolean isVaild(ArrayList<String> temp, int row, int col, int n) {


        for(int i = row - 1; i >= 0; i--){
            if(temp.get(i).charAt(col) == 'Q'){
                return false;
            }
        }

        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0 ; i--, j--){
            if(temp.get(i).charAt(j) == 'Q'){
                return false;
            }
        }


        for(int i = row - 1, j = col + 1;i >= 0 && j < n ; i--, j++){
            if(temp.get(i).charAt(j) == 'Q'){
                return false;
            }
        }

        return true;
    }


}
