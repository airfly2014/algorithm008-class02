package training;

/**
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 * 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 */
public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix == null || matrix.length < 1){
            return false;
        }

        int row = matrix.length;
        int column = matrix[0].length;

        int left = 0;
        int right = row * column - 1;

        while (left <= right){
            int mid = left + (right - left) / 2;

            int r = mid / column;
            int c = mid % column;
            int t = matrix[r][c];
            if(t == target){
                return true;
            }else if(t > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return false;
    }


}
