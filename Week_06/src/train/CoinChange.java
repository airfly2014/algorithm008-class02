package train;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/coin-change/
 * <p>
 * 322. 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释:
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {

        int[] r = new int[amount + 1];
        Arrays.fill(r, amount + 1);
        r[0] = 0;
        for(int coin : coins){
            for(int i = coin; i < amount + 1; i++)
                r[i] = Math.min(r[i], r[i - coin] + 1);
        }

        return r[amount] > amount ? -1 : r[amount];
    }

}
