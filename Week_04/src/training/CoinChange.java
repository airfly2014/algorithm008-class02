package training;

/**
 * https://leetcode-cn.com/problems/coin-change/
 * 322. 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {

        int[] r = new int[amount + 1];
        for(int i = 1; i < amount + 1; i++){
            r[i] = amount + 1;
        }

        for(int coin : coins){
            for(int i = coin; i < amount + 1; i++){
                r[i] = Math.min(r[i], r[i - coin] + 1);
            }
        }

        return r[amount] > amount  ? -1 : r[amount];
    }
}
