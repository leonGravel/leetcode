package math;

/**
 * @ClassName IsUgly
 * @Description: 判断丑数
 * @Author gravel
 * @Date 2019/12/7
 * @Version V1.0
 **/
public class IsUgly {
    public boolean isUgly(int num) {
        if(num==1) return true;
        while (num>1){
            int temp = num;
            while (temp%2==0) temp /= 2;
            while (temp%3==0) temp /= 3;
            while (temp%5==0) temp /= 5;
            if(num==temp) return false;
            num=temp;
        }
        return true;
    }
}
