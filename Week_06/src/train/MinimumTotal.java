package train;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/triangle/
 * 120. 三角形最小路径和
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * <p>
 * <p>
 * <p>
 * 例如，给定三角形：
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 */
public class MinimumTotal {

    //    [[2],[3,4],[6,5,7],[4,1,8,3]]
    public static void main(String argv[]) {
        MinimumTotal minimumTotal = new MinimumTotal();
        ArrayList<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(3, 4));
        int result = minimumTotal.minimumTotal(list);
        System.out.println(result);

    }
//
//    public int minimumTotal(List<List<Integer>> triangle) {
//
//        int length = triangle.size();
//        int[][] dp = new int[length][length];
//        for(int i = triangle.size() - 1; i >= 0; i--){
//            for(int j = 0; j < triangle.get(i).size(); j++){
//                if(i == triangle.size() - 1){
//                    dp[i][j] = triangle.get(i).get(j);
//                }else{
//
//                    System.out.println(triangle.get(i).get(j));
//                    System.out.println(dp[i + 1][j]);
//                    System.out.println(dp[i + 1][j + 1]);
//                    dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
//                    System.out.println(dp[i][j]);
//                }
//            }
//        }
//        return dp[0][0];
//    }

    public int minimumTotal(List<List<Integer>> triangle) {

        int length = triangle.size();
        int[] dp = new int[length + 1];
        for(int i = triangle.size() - 1; i >=0; i--){
           for(int j = 0; j < triangle.get(i).size(); j++){
               dp[j] = triangle.get(i).get(j) + Math.min(dp[j],dp[j + 1]);
           }
        }
        return dp[0];
    }


}
