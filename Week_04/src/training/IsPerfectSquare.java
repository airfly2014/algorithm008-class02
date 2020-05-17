package training;

/**
 * https://leetcode-cn.com/problems/valid-perfect-square/
 * 367. 有效的完全平方数
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 *
 * 说明：不要使用任何内置的库函数，如  sqrt。
 *
 * 示例 1：
 *
 * 输入：16
 * 输出：True
 */
public class IsPerfectSquare {



    public static void main(String[] args) {
        IsPerfectSquare isPerfectSquare = new IsPerfectSquare();
        isPerfectSquare.isPerfectSquare(4);
    }

    public boolean isPerfectSquare(int num) {

        if(num == 1){
            return true;
        }

        long left = 1;
        long right = num + 1;
        long mid;
        while (left < right){

            mid = (left + right) >> 1;
            long square = mid * mid;
            if(square == num){
                return true;
            }else if(square > num){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }


        return left * left == num;
    }
}
