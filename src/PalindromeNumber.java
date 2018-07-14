/**
 * Created by leebr on 2018/7/14.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        return String.valueOf(x).equals(new StringBuffer().append(x).reverse().toString());
    }
}

