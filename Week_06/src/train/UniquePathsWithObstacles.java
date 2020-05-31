package train;

/**
 *
 *
 *https://leetcode-cn.com/problems/unique-paths-ii/
 * 63. 不同路径 II
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 */


public class UniquePathsWithObstacles {


    public static void main(String argv[]){
        UniquePathsWithObstacles paths = new UniquePathsWithObstacles();
        int test[][] = {{1}};
//        int test[][] = {{0,0,0},{0,1,0},{0,0,0}};
        paths.uniquePathsWithObstacles(test);


    }

//    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//
//        int m = obstacleGrid.length;
//        int n = obstacleGrid[0].length;
//        int dp[][] = new int[m][n];
//
//
//        for (int i = 0; i < m; i++) {
//            if (obstacleGrid[i][0] == 1) {
//                break;
//            } else {
//                dp[i][0] = 1;
//            }
//        }
//
//        for (int i = 0; i < n; i++) {
//            if (obstacleGrid[0][i] == 1) {
//                break;
//            } else {
//                dp[0][i] = 1;
//            }
//        }
//
//
//        for(int i = 1; i < m; i++){
//            for(int j = 1; j < n; j++){
//                dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i - 1][j] + dp[i][j - 1];
//            }
//        }
//
//        return dp[m - 1][n - 1];
//    }


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = 1;

        for(int[] lineArr : obstacleGrid){
            for(int i = 0; i < n; i++){
                if(lineArr[i] == 1){
                    dp[i] = 0;
                }else if(i > 0){
                    dp[i] += dp[i - 1];
                }
            }
        }
        return dp[n  - 1];
    }

}
