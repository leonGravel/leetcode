/**
 * Created by leebr on 2018/8/31.
 * 编写一个函数来查找字符串数组中的最长公共前缀。

 如果不存在公共前缀，返回空字符串 ""。

 示例 1:

 输入: ["flower","flow","flight"]
 输出: "fl"
 示例 2:

 输入: ["dog","racecar","car"]
 输出: ""
 解释: 输入不存在公共前缀。
 说明:

 所有输入只包含小写字母 a-z 。
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String temp = strs[i];
            for (int j = result.length(); j >= 0; j--) {
                if (j <= temp.length() && temp.substring(0, j).equals(result.substring(0, j))) {
                    result = result.substring(0, j);
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
}
