package training;

/**
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 * 153. 寻找旋转排序数组中的最小值
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 请找出其中最小的元素。
 *
 * 你可以假设数组中不存在重复元素。
 *
 * 示例 1:
 *
 * 输入: [3,4,5,1,2]
 * 输出: 1
 */
public class FindMin {


    public int findMin(int[] nums) {

       int start = 0;
       int end = nums.length - 1;
       while (start < end){
           if(nums[start] < nums[end]){
               return nums[start];
           }
           int mid = start + (end - start) / 2;
           if(nums[start] < nums[mid]){
               start = mid + 1;
           }else{
               end = mid;
           }
       }
        return nums[start];
    }
}
