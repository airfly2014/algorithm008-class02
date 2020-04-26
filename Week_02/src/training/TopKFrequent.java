package training;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 * 347. 前 K 个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 */
public class TopKFrequent {

    /**
     * 使用优先队列
     * 存放pair，使用key排序
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int num : nums){
           count.put(num, count.getOrDefault(num,0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return count.get(o1) - count.get(o2);
            }
        });


        for(int n : count.keySet()){
            queue.add(n);
            if(queue.size() > k){
                queue.poll();
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()){
            list.add(queue.poll());
        }

        int[] result = new int[list.size()];
        for(int i = 0; i < list.size();i++){
            result[list.size() - 1 -i] = list.get(i);
        }

        return result;
    }
}
