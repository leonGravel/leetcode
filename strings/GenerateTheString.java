package strings;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName GenerateTheString
 * @Description: TODO
 * @Author gravel
 * @Date 2020/3/8
 * @Version V1.0
 **/
public class GenerateTheString {
    public String generateTheString(int n) {
        if(n==1) return "a";
        if (n % 2 == 0) {
            return Stream.generate(() -> "a").limit(n - 1).collect(Collectors.joining()) + "b";
        } else {
            return Stream.generate(() -> "a").limit(n - 2).collect(Collectors.joining()) + "bc";
        }
    }

    public static void main(String[] args) {
        System.out.println(new GenerateTheString().generateTheString(500));
    }
}
