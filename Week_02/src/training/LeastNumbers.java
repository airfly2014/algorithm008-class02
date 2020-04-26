package training;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 * 面试题40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 使用优先小堆
 *
 */
public class LeastNumbers {

    public int[] getLeastNumbers(int[] arr, int k) {

        int[] ans = new int[k];
        PriorityQueue<Integer> elements = new PriorityQueue<>();
        for(int ele : arr){
            elements.add(ele);
        }

        for(int i = 0; i < k; i++){
            ans[i] = elements.poll();
        }

        return ans;
    }


    /**
     * 类似字典法，在数据取值范围可预估时，能够使用
     * 取巧方案，数据量在不可预计范围时，不可以这个方法
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers2(int[] arr, int k) {

        int[] counts = new int[10001];
        for(int ele : arr){
            counts[ele]++;
        }

        int id = 0;
        int[] results = new int[k];
        for(int i = 0; i < counts.length; i++){
            while ( counts[i]-- > 0 && id < k){
                results[id++] = i;
            }

            if(id == k){
                break;
            }
        }

        return results;
    }
}
