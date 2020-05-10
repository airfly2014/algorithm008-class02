package training;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-mei-ju-shi-jian-dan-qu-zhong
 * -ji-ke-by-emili/
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PermuteUnique {

    public List<List<Integer>> permuteUnique(int[] nums) {

        ArrayList<List<Integer>> results = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        for(int num : nums){
            temp.add(num);
        }

        permuteUnique(results, temp, 0, temp.size());
        return results;
    }

    private void permuteUnique(ArrayList<List<Integer>> results, ArrayList<Integer> temp, int pos, int n) {
        if(pos == n){
            results.add(new ArrayList<>(temp));
            return;
        }

        HashSet<Integer> unique = new HashSet<>();
        for(int i = pos; i < n; i++){
            if(unique.contains(temp.get(i))){
                continue;
            }

            unique.add(temp.get(i));
            Collections.swap(temp, i, pos);
            permuteUnique(results, temp, pos + 1, n);
            Collections.swap(temp, pos, i);
        }
    }
}
