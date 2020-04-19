package training;

/**
 * 作业
 */
public class Exercise {

    /**
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
     * <p>
     * 26. 删除排序数组中的重复项
     * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * <p>
     * 示例 1:
     * <p>
     * 给定数组 nums = [1,1,2],
     * <p>
     * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
     * <p>
     * 你不需要考虑数组中超出新长度后面的元素。
     * 示例 2:
     * <p>
     * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
     * <p>
     * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
     */

    public int removeDuplicates(int[] nums) {

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                if (j > ++i) {
                    nums[i] = nums[j];
                }

            }
        }

        return i + 1;
    }


//    https://leetcode-cn.com/problems/rotate-array/

    /**
     * 189. 旋转数组
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     *
     * 示例 1:
     *
     * 输入: [1,2,3,4,5,6,7] 和 k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右旋转 1 步: [7,1,2,3,4,5,6]
     * 向右旋转 2 步: [6,7,1,2,3,4,5]
     *
     * 示例 2:
     *
     * 输入: [-1,-100,3,99] 和 k = 2
     * 输出: [3,99,-1,-100]
     * 解释:
     * 向右旋转 1 步: [99,-1,-100,3]
     * 向右旋转 2 步: [3,99,-1,-100]
     * 说明:
     *
     * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
     * 要求使用空间复杂度为 O(1) 的 原地 算法。
     *
     * @param nums
     * @param k
     */

    /**
     * 反推，转换后位置i，的数据，是从哪个位置来的。。。
     * (i + nums.length  + (k/nums.length + 1) * nums.length  - k) % nums.length
     * 比如原始位置为j ，转换公式 则为 i = (j + k) % nums.length;
     * 则 i + nums.length * 未知个数 = j + k;
     * j = i + nums.length * 未知个数 - k;
     * j还需对数组长度取摸  j = (i + nums.length * 未知个数 - k) % nums.length;
     *
     * @param nums
     * @param k
     */
//    public void rotate(int[] nums, int k) {
//
//        int[] tempNums = new int[nums.length];
//
//        System.arraycopy(nums, 0, tempNums, 0, nums.length);
//
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = tempNums[(i + nums.length  + (k/nums.length + 1) * nums.length  - k) %
// nums.length];
//        }
//    }
    public void rotate(int[] nums, int k) {

        k = k % nums.length;
        reverseArray(nums, 0, nums.length - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, nums.length - 1);

    }

    public void reverseArray(int nums[], int start, int end) {

        int temp;
        while (start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


    public static class ListNode {
        int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    /**
     * https://leetcode-cn.com/problems/merge-two-sorted-lists/
     * 21. 合并两个有序链表
     * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * <p>
     * 示例：
     * <p>
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     */

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                head = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                head = l2;
                l2 = l2.next;
            }
        }

        head.next = l1 == null ? l2 : l1;

        return dummy.next;
    }

    /**
     * https://leetcode-cn.com/problems/merge-sorted-array/
     * <p>
     * 88. 合并两个有序数组
     * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
     * <p>
     * <p>
     * <p>
     * 说明:
     * <p>
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
     * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     * <p>
     * <p>
     * 示例:
     * <p>
     * 输入:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     * <p>
     * 输出: [1,2,2,3,5,6]
     */

//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//
//        int result[] = new int[m + n];
//
//        int i = 0;
//        int j = 0;
//        int k = 0;
//        while (i < m && j < n) {
//            result[k++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
//        }
//
//        while (i < m){
//            result[k++] = nums1[i++];
//        }
//
//        while (j < n){
//            result[k++] = nums2[j++];
//        }
//
//        System.arraycopy(result, 0, nums1, 0, m+n);
//    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {


        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;

        while (p1 >= 0 && p2 >= 0) {
            nums1[p--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        }

        if (p2 >= 0) {
            System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        }

    }

    /**
     * https://leetcode-cn.com/problems/plus-one/
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     * <p>
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * <p>
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [1,2,3]
     * 输出: [1,2,4]
     * 解释: 输入数组表示数字 123。
     * 示例 2:
     * <p>
     * 输入: [4,3,2,1]
     * 输出: [4,3,2,2]
     * 解释: 输入数组表示数字 4321。
     */

    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] += 1;
                return digits;
            }
            digits[i] = 0;
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    /**
     * https://leetcode-cn.com/problems/move-zeroes/
     * 283. 移动零
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * <p>
     * 示例:
     * <p>
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 说明:
     * <p>
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     */

    public void moveZeroes(int[] nums) {
        int i = 0;
        for(int j = 0; j < nums.length; j++){
            if(j > i){
                nums[i] = nums[j];
                nums[j] = 0;
            }
            i++;
        }
    }
}
