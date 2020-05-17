package training;

/**
 * https://leetcode-cn.com/problems/sqrtx/
 *
 * 69. x 的平方根
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 */
public class MySqrt {

//    public int mySqrt(int x) {
//
//        long left = 0;
//        long right = x / 2  + 1;
//        long mid;
//
//        while (left < right){
//
//            mid = (left + right + 1) >> 1;
//            long square = mid * mid;
//            if(square > x){
//                right = mid - 1;
//            }else if(square < x){
//                left = mid;
//            }else{
//                return (int)mid;
//            }
//
//        }
//        return (int)left;
//    }

    public int mySqrt(int a) {

        long x = a;
        while (x * x > a){
            x = (x + a / x) / 2;
        }

        return (int) x;
    }
}
