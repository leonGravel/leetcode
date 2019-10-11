package strings;

/**
 * @author Gravel
 * @date 2019/10/11.
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 */
public class IsPalindrome {
    public boolean isPalindrome(String s) {
        if (s.length() < 1) return true;
        int left = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left < right) {
            //调整空格
            if ((int) chars[left] == 32) left++;

            if ((int) chars[right] == 32) right--;
            //调整大写 A-Z 65-90 || a-z 97-122
            if ((int) chars[left] >= 65 && (int) chars[left] <= 90) chars[left] = (char) ((int) chars[left] + 32);
            if ((int) chars[right] >= 65 && (int) chars[right] <= 90) chars[right] = (char) ((int) chars[right] + 32);
            //验证目标字符为数字或字母
            boolean flag1 = (chars[left] >= '0' && chars[left] <= '9') || (chars[left] >= 'a' && chars[left] <= 'z');
            boolean flag2 = (chars[right] >= '0' && chars[right] <= '9') || (chars[right] >= 'a' && chars[right] <= 'z');
            if (flag1 && flag2 && chars[left] != chars[right]) {
                return false;
            }
            if (!flag1&&flag2) {
                left++;
            }else if(!flag2&&flag1){
                right--;
            }else{
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new IsPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
    }
}
