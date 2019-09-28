package strings;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Gravel
 * @date 2019/9/28.
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 一般的解题思路：hash一次，反遍历另一个字符，如果有不符合的返回false
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 *
 */
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        char[] a = unicodeToString(s).toCharArray();
        char[] b = unicodeToString(t).toCharArray();
        if(a.length!=b.length) return false;
        Map<Character,Integer> map = new HashMap<>();
        for(int i= 0;i<a.length;i++){
            if(map.get(a[i])==null){
                map.put(a[i],1);
            }else{
                map.put(a[i],map.get(a[i])+1);
            }
        }
        for(int i=0;i<b.length;i++){
            if(map.get(b[i])==null){
                return false;
            }
            map.put(b[i],map.get(b[i])-1);
            if(map.get(b[i])<0){
                return false;
            }
        }
        for(int i=0;i<b.length;i++){
            if(map.get(b[i])!=0){
                return false;
            }
        }
        return true;
    }

    /**
     * 替换文本中的unicode字符安
     * @param unicode
     * @return
     */
    public static String unicodeToString(String unicode) {
        if(!unicode.contains("\\\\u")) return unicode;
        StringBuffer sb = new StringBuffer();
        String[] hex = unicode.split("\\\\u");
        for (int i = 1; i < hex.length; i++) {
            String unicodeStr = hex[i].substring(0,4);
            String str = hex[i].substring(4);
            int index = Integer.parseInt(unicodeStr, 16);
            sb.append((char) index).append(str);
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(new IsAnagram().isAnagram("anagram","nagaram"));
    }
}
