package math;

import utils.CommonUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName FizzBuzz
 * @Description: TODO
 * @Author gravel
 * @Date 2019/11/28
 * @Version V1.0
 *
 * 思路：一次遍历，然后挨着运算？？？？？
 **/
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>(n);
        int i = 1;
        while (i <= n) {
            String temp = "";
            if (i % 3 == 0 && i % 5 != 0) {
                temp = "Fizz";
            } else if (i % 3 != 0 && i % 5 == 0) {
                temp = "Buzz";
            } else if (i % 3 == 0 && i % 5 == 0) {
                temp = "FizzBuzz";
            } else {
                temp = String.valueOf(i);
            }
            result.add(temp);
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        new FizzBuzz().fizzBuzz(30).forEach(e -> System.out.println(e));
    }

}
