package training;

import java.util.ArrayDeque;

/**
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 *
 * 239. 滑动窗口最大值
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 *
 *
 * 进阶：
 *
 * 你能在线性时间复杂度内解决此题吗？
 */
public class SlidingWindow {


    public static void main(String[] args) {
        SlidingWindow slidingWindow = new SlidingWindow();
        slidingWindow.maxSlidingWindow(new int[]{7,2,4},2);
    }


    public int[] maxSlidingWindow(int[] nums, int k) {


        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] results = new int[nums.length - k + 1];


        for(int i = 0; i < nums.length; i++){

            if(!queue.isEmpty() && queue.peekFirst() == i - k){
                queue.removeFirst();
            }

            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]){
                queue.removeLast();
            }

            queue.addLast(i);


            if(i > k - 2){
                results[i - k + 1] = nums[queue.peekFirst()];
            }
        }

        return results;
    }



}
