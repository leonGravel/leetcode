package number;

/**
 * @author Gravel
 * @date 2018/7/15.
 *
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。

 * 示例 1:
 * 输入: 123
 * 输出: 321

 * 示例 2:
 * 输入: -123
 * 输出: -321

 * 示例 3:
 * 输入: 120
 * 输出: 21
 */
public class ReverseInteger {
    public int reverse(int x) {
        StringBuffer s = new StringBuffer().append(x);
        String newNum = "";
        if (x < 0) {
            newNum = new StringBuffer(s.reverse()).substring(0, s.length() - 1);
        } else {
            newNum = new StringBuffer(s.reverse()).toString();
        }
        try {
            return (x < 0) ? -Integer.valueOf(newNum) : Integer.valueOf(newNum);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
    public static void main(String[] args) throws Exception {
        System.out.println(new ReverseInteger().reverse(121));
    }
}
