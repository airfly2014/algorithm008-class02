package train;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {

        int max = nums[0];
        int segment = nums[0];
        for(int i = 1; i < nums.length; i++){
            int num = nums[i];
            segment = Math.max(segment + num, num);
            max = Math.max(max, segment);
        }
        return max;
    }
}
