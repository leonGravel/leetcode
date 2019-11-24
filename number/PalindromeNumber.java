package number;

/**
 * @author Gravel
 * @date 2018/7/14.
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

 * 示例 1:
 * 输入: 121
 * 输出: true

 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。

 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        return String.valueOf(x).equals(new StringBuffer().append(x).reverse().toString());
    }
    public static void main(String[] args) throws Exception {
        System.out.println(new PalindromeNumber().isPalindrome(121));
    }
}

