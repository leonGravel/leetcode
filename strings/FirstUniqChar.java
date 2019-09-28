package strings;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Gravel
 * @date 2019/9/28.
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *
 *
 * 注意事项：您可以假定该字符串只包含小写字母。
 *
 * 解题思路： Hash 一次，遍历一次
 */
public class FirstUniqChar {
    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for(int i= 0;i<chars.length;i++){
            if(map.get(chars[i])==null){
                map.put(chars[i],0);
            }else{
                map.put(chars[i],map.get(chars[i])+1);
            }
        }
        for(int i=0;i<chars.length;i++){
            if(map.get(chars[i])<1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new FirstUniqChar().firstUniqChar("loveleetcode"));
    }
}
