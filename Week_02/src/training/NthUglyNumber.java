package training;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/chou-shu-lcof/solution/dui-he-dong-tai-gui-hua-si-lu-xiang-jie-by-jerry_n/
 * 面试题49. 丑数
 * 我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 *
 *
 *
 * 示例:
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 */
public class NthUglyNumber {

    public int nthUglyNumber(int n) {

        int[] base = {2, 3, 5};
        PriorityQueue<Long> queue = new PriorityQueue<>();
        HashSet<Long> hashSet = new HashSet<>();
        queue.add(1l);
        for(int i = 1;i < n;i++){
            long current = queue.poll();
            for(int b : base){
                long temp = current * b;
                if(!hashSet.contains(temp)){
                    hashSet.add(temp);
                    queue.add(temp);
                }
            }
        }

        return Math.toIntExact(queue.poll());
    }



}
