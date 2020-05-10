package training;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 */
public class ClimbStairs {


    public int climbStairs(int n) {

        if(n == 1 || n == 2){
            return n;
        }

        int f1 = 1;
        int f2 = 2;

        for(int i = 3; i <=n; i++){

            int f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }

        return f2;
    }
}
