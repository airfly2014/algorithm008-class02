package training;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/
 * 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Permute {

    public List<List<Integer>> permute(int[] nums) {

        ArrayList<List<Integer>> results = new ArrayList<List<Integer>>();
        ArrayList<Integer> temp = new ArrayList<>();
        for(int num : nums){
            temp.add(num);
        }

        permute(results, temp, 0 , temp.size());

        return results;
    }

    private void permute(ArrayList<List<Integer>> results, ArrayList<Integer> temp, int pos, int n) {

        if(pos == n){
            results.add(new ArrayList<>(temp));
            return;
        }

        for(int i = pos; i < n; i++){

            Collections.swap(temp, pos, i);
            permute(results, temp, pos + 1, n);
            Collections.swap(temp, i, pos);
        }
    }

}
