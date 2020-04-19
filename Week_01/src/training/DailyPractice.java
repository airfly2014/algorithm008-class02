package training;

import java.util.LinkedHashMap;
import java.util.Map;

public class DailyPractice {

    /**
     * https://leetcode-cn.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
     * 1281. 整数的各位积和之差
     * 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 234
     * 输出：15
     * 解释：
     * 各位数之积 = 2 * 3 * 4 = 24
     * 各位数之和 = 2 + 3 + 4 = 9
     * 结果 = 24 - 9 = 15
     * 示例 2：
     * <p>
     * 输入：n = 4421
     * 输出：21
     * 解释：
     * 各位数之积 = 4 * 4 * 2 * 1 = 32
     * 各位数之和 = 4 + 4 + 2 + 1 = 11
     * 结果 = 32 - 11 = 21
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= n <= 10^5
     * 通过次数17,022提交次数
     */

    public int subtractProductAndSum(int n) {

        int multi = 1;
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            multi *= digit;
            sum += digit;
            n = n / 10;
        }

        return multi - sum;
    }


    /**
     * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
     * 977. 有序数组的平方
     * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：[-4,-1,0,3,10]
     * 输出：[0,1,9,16,100]
     * 示例 2：
     * <p>
     * 输入：[-7,-3,2,3,11]
     * 输出：[4,9,9,49,121]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= A.length <= 10000
     * -10000 <= A[i] <= 10000
     * A 已按非递减顺序排序。
     * 通过次数34,051提交次数47,83
     */


//    public int[] sortedSquares(int[] A) {
//
//        for(int i = 0; i < A.length; i++){
//            A[i] = A[i] * A[i];
//        }
//        Arrays.sort(A);
//        return A;
//    }
//    public int[] sortedSquares(int[] A) {
//
//        int j = 0;
//        while (j < A.length && A[j] < 0) {
//            j++;
//        }
//
//        int[] result = new int[A.length];
//        int current = 0;
//        int i = j - 1;
//        while (i >= 0 && j < A.length) {
//            if (A[i] * A[i] < A[j] * A[j]) {
//                result[current++] = A[i] * A[i];
//                i--;
//            } else {
//                result[current++] = A[j] * A[j];
//                j++;
//            }
//        }
//
//        while (i >= 0) {
//            result[current++] = A[i] * A[i];
//            i--;
//        }
//
//        while (j < A.length) {
//            result[current++] = A[j] * A[j];
//            j++;
//        }
//
//        return result;
//    }
    public int[] sortedSquares(int[] A) {

        int[] result = new int[A.length];
        int i = 0;
        int j = A.length - 1;
        for (int p = j; p >= 0; p--) {
            if (Math.abs(A[i]) > Math.abs(A[j])) {
                result[p] = A[i] * A[i];
                i++;
            } else {
                result[p] = A[j] * A[j];
                j--;
            }
        }

        return result;
    }


    /**
     * https://leetcode-cn.com/problems/split-a-string-in-balanced-strings/
     * 1221. 分割平衡字符串
     * 在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。
     * <p>
     * 给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
     * <p>
     * 返回可以通过分割得到的平衡字符串的最大数量。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "RLRRLLRLRL"
     * 输出：4
     * 解释：s 可以分割为 "RL", "RRLL", "RL", "RL", 每个子字符串中都包含相同数量的 'L' 和 'R'。
     * 示例 2：
     * <p>
     * 输入：s = "RLLLLRRRLR"
     * 输出：3
     * 解释：s 可以分割为 "RL", "LLLRRR", "LR", 每个子字符串中都包含相同数量的 'L' 和 'R'。
     * 示例 3：
     * <p>
     * 输入：s = "LLLLRRRR"
     * 输出：1
     * 解释：s 只能保持原样 "LLLLRRRR".
     */

    public int balancedStringSplit(String s) {
        int cnt = 0;
        int balance = 0;
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == 'L') {
                balance -= 1;
            } else if (s.charAt(i) == 'R') {
                balance += 1;
            }

            if (balance == 0) {
                cnt++;
            }
        }
        return cnt;
    }

    /**
     * https://leetcode-cn.com/problems/reverse-only-letters/
     * 917. 仅仅反转字母
     * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入："ab-cd"
     * 输出："dc-ba"
     * 示例 2：
     * <p>
     * 输入："a-bC-dEf-ghIj"
     * 输出："j-Ih-gfE-dCba"
     * 示例 3：
     * <p>
     * 输入："Test1ng-Leet=code-Q!"
     * 输出："Qedo1ct-eeLg=ntse-T!"
     */

   /* public String reverseOnlyLetters(String S) {

        StringBuilder builder = new StringBuilder(S);
        Stack stack = new Stack();

         int length = builder.length();
         for(int i = 0; i < length; i++){
             if(isAlphabet(builder.charAt(i))){
                 stack.push(builder.charAt(i));
             }
         }

        for(int i = 0; i < length; i++){
            if(isAlphabet(builder.charAt(i))){
                builder.replace(i,i+1, String.valueOf(stack.pop()));
            }
        }


        return builder.toString();
    }

    private boolean isAlphabet(char c){
        return  (c >= 65 && c <= 90) || (c >= 97 && c <= 122);
    }*/


//    public String reverseOnlyLetters(String S) {
//
//        StringBuilder builder = new StringBuilder();
//        int j = S.length() - 1;
//        for(int i = 0; i < S.length(); i++){
//            if(Character.isLetter(S.charAt(i))){
//                while (!Character.isLetter(S.charAt(j))){
//                    j--;
//                }
//
//                builder.append(S.charAt(j--));
//            }else{
//                builder.append(S.charAt(i));
//            }
//        }
//
//        return builder.toString();
//    }
    public String reverseOnlyLetters(String S) {
        StringBuilder builder = new StringBuilder(S);
        for (int i = 0, j = S.length() - 1; i < j; ) {

            while (i < j && !Character.isLetter(S.charAt(i))) {
                i++;
            }

            while (i < j && !Character.isLetter(S.charAt(j))) {
                j--;
            }

            if (i < j) {
                builder.setCharAt(i, S.charAt(j));
                builder.setCharAt(j, S.charAt(i));
                i++;
                j--;
            }

        }
        return builder.toString();
    }

    /**
     * https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
     * 面试题50. 第一个只出现一次的字符
     * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。
     * <p>
     * 示例:
     * <p>
     * s = "abaccdeff"
     * 返回 "b"
     * <p>
     * s = ""
     * 返回 " "
     */

    //大力出奇迹
//    public char firstUniqChar(String s) {
//
//        HashMap<Character, Integer> hashMap = new HashMap<>();
//        ArrayList<Character> characters = new ArrayList<>();
//        for(int i = 0; i < s.length(); i++){
//            if(hashMap.containsKey(s.charAt(i))){
//                characters.remove((Character) s.charAt(i));
//            }else{
//                hashMap.put(s.charAt(i),i);
//                characters.add(s.charAt(i));
//            }
//        }
//        return characters.size() > 0 ? characters.get(0) : ' ';
//    }


        public char firstUniqChar(String s) {

            LinkedHashMap<Character, Boolean> hashMap = new LinkedHashMap<>();
            for(Character c : s.toCharArray()){
                hashMap.put(c,!hashMap.containsKey(c));
            }

            for(Map.Entry<Character, Boolean> entry : hashMap.entrySet()){

                if(entry.getValue()){
                    return entry.getKey();
                }
            }

            return ' ';
        }



}
