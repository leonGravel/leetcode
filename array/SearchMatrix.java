package array;

/**
 * @ClassName SearchMatrix
 * @Description: 搜索二维矩阵
 * @Author gravel
 * @Date 2019/11/11
 * @Version V1.0
 **/
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int len = matrix.length;

        int i = len / 2;
        while (i < matrix.length && i >= 0) {

            if (matrix[i][0] < target && target <= matrix[i][matrix[0].length - 1]) {
                int j = matrix[0].length - 1;
                while (j >= 0) {
                    if (target == matrix[i][j]) return true;
                    j--;
                }
                return false;
            }

            if (target > matrix[i][matrix[0].length - 1] && (i + 1) < matrix.length && target < matrix[i + 1][0])
                return false;


            if (matrix[i][0] < target) {
                i++;
            } else if (matrix[i][0] > target) {
                i--;
            } else {
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1}};
        System.out.println(new SearchMatrix().searchMatrix(arr, 2));
    }
}
