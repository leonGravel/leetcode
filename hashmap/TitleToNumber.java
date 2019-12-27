package hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName TitleToNumber
 * @Description: Excel表列序号
 * @Author gravel
 * @Date 2019/12/27
 * @Version V1.0
 * 思路：
 * 简单的进制转换，维护一个映射关系
 **/
public class TitleToNumber {
    public int titleToNumber(String s) {
        if (s == null || s.trim().equals("")) {
            return 0;
        }
        s = s.toUpperCase();
        String az = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Map<String, Integer> map = new HashMap<>(26, 1);
        for (int j = 1; j <= az.length(); j++) {
            map.put(az.substring(j-1, j), j);
        }
        int result = 0;
        int index = 1;
        for (int i = s.length(); i > 0; i--) {
            String item = s.substring(i - 1, i);
            result += index * map.get(item);
            index *= 26;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new TitleToNumber().titleToNumber("ZY"));
    }
}
