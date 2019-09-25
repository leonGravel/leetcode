package strings;

/**
 * @author Gravel
 * @date 2019/9/25.
 * <p>
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class ReverseInt {
    public int ReverseInt(int x) {
        if (x == 0) return 0;
        char[] a = String.valueOf(x).replace("-", "").toCharArray();
        int j = 0;
        for (int i = a.length - 1; i > j; i--) {
            char temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            j++;
        }
        int result = 0;
        try {
            result = Integer.parseInt(String.valueOf(a));
        } catch (Exception e) {
            return 0;
        }
        if (x < 0) {
            return 0 - result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseInt().ReverseInt(-123));
    }
}
