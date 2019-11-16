package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Gravel
 * @date 2019/9/18.
 *
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 *
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 * 示例 2:
 *
 * 输入:
 * [
 *   ["8","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: false
 * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 *      但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 * 说明:
 *
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 给定数独序列只包含数字 1-9 和字符 '.' 。
 * 给定数独永远是 9x9 形式的。

 */
public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i+=3){
            for(int j=0;j<9;j+=3){
                char[] x = new char[9];
                int k = 0;
                for(int m=0;m<3;m++){
                    for(int n=0;n<3;n++){
                        x[k] = board[j+n][i+m];
                        k++;
                    }
                }
                if(!isSudoku(x)){
                    return false;
                }
            }
        }
        for(int i=0;i<board[0].length;i++){
            char[] x = new char[9];
            if(!isSudoku(board[i])){
                return false;
            }
            for(int j=0;j<9;j++){
                x[j] = board[j][i];
            }
            if(!isSudoku(x)){
                return false;
            }
        }
        return true;
    }

    private boolean isSudoku(char [] chars){
        Map<Character,Integer> map = new HashMap<>();
        for(char c: chars){
            if(c!='.'){
                Integer v = map.get(c);
                v = v==null?0:v;
                map.put(c,++v);
                if(map.get(c)>1){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) throws Exception {
        char[][] sudoku = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','7','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println(new IsValidSudoku().isValidSudoku(sudoku));
}
    }