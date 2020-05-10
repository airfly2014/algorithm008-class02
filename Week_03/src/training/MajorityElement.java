package training;

/**
 * https://leetcode-cn.com/problems/majority-element/solution/duo-shu-yuan-su-by-leetcode-solution/
 * 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 */
public class MajorityElement {


//    public int majorityElement(int[] nums) {
//
//        return majorityElement(nums, 0, nums.length -1);
//    }
//
//    private int majorityElement(int[] nums, int lo, int hi) {
//
//        if(lo == hi){
//            return nums[lo];
//        }
//
//        int mid = (lo + hi) / 2;
//        int left = majorityElement(nums, lo, mid);
//        int right = majorityElement(nums, mid + 1, hi);
//
//        if(left == right){
//            return left;
//        }
//
//        int leftCount = count(nums, left);
//        int rightCount = count(nums, right);
//
//
//
//        return  leftCount > rightCount ? left : right;
//    }
//
//    private int count(int[] nums, int target) {
//
//        int count = 0;
//        for(int num : nums){
//            if(num == target){
//                count++;
//            }
//        }
//
//        return count;
//    }

//    public int majorityElement(int[] nums) {
//        Arrays.sort(nums);
//        return nums[nums.length / 2];
//    }


    //摩尔投票法
//    public int majorityElement(int[] nums) {
//         int card_num = nums[0];
//         int card_count = 1;
//         for(int i = 1; i < nums.length; i++){
//             if(card_num == nums[i]){
//                 card_count++;
//             }else if(--card_count == 0){
//                 card_num = nums[i];
//                 card_count = 1;
//             }
//         }
//
//         return card_num;
//    }


    public int majorityElement(int[] nums) {

        int count = 1;
        int target = nums[0];

        for(int i = 1; i < nums.length; i++){
            if(nums[i] != target){
                count--;
            }else{
                count++;
            }

            if(count == 0){
                target = nums[i];
                count = 1;
            }
        }

        return target;
    }
}
