package utils;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

/**
 * 工具类，提供一些基础的工具类方法，类似翻转数组,打印数组
 * @author Gravel
 * @date 2019/9/9.
 */
public class CommonUtils {
    public static void printArr(int [] nums){
        StringBuffer sb = new StringBuffer("[");
        Arrays.stream(nums).forEach(value -> sb.append(value).append(","));
        System.out.println(new StringBuffer(sb.substring(0,sb.length()-1)).append("]").toString());
    }
}
