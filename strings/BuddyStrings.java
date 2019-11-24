package strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Gravel
 * @date 2018/9/2.
 * <p>
 * 给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： A = "ab", B = "ba"
 * 输出： true
 * 示例 2：
 * <p>
 * 输入： A = "ab", B = "ab"
 * 输出： false
 * 示例 3:
 * <p>
 * 输入： A = "aa", B = "aa"
 * 输出： true
 * 示例 4：
 * <p>
 * 输入： A = "aaaaaaabc", B = "aaaaaaacb"
 * 输出： true
 * 示例 5：
 * <p>
 * 输入： A = "", B = "aa"
 * 输出： false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= A.length <= 20000
 * 0 <= B.length <= 20000
 * A 和 B 仅由小写字母构成。
 */
public class BuddyStrings {
    public boolean buddyStrings(String A, String B) {
        if(A.length()!=B.length()) return false;
        if(A.equals(B)){
            Set<Character> set = new HashSet<>();
            char [] ArrayA = A.toCharArray();
            for(char a : ArrayA){
                set.add(a);
            }
            if(set.size()==ArrayA.length) return false;
            else return true;
        }
        List<Integer> index = new ArrayList<>();
        for(int i=0;i<A.length();i++){
            if(A.charAt(i)!=B.charAt(i)){
                index.add(i);
            }
            if(index.size()>2) return false;
        }
        if(index.size()==2&&A.charAt(index.get(0))==B.charAt(index.get(1))&&A.charAt(index.get(1))==B.charAt(index.get(0)))
            return true;
        else
            return false;
    }
    public static void main(String[] args) throws Exception {
        System.out.println(new BuddyStrings().buddyStrings("aa","ab"));
    }
}
