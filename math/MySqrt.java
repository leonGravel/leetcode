package math;

/**
 * @ClassName MySqrt
 * @Description: x 的平方根
 * @Author gravel
 * @Date 2019/12/11
 * @Version V1.0
 * 思路：
 *  二分查找。。。
 *
 **/
public class MySqrt {
    public int mySqrt(int x) {
        if(x<1) return 0;
        double res = 1d;
        int hi = x;
        int lo = 1;
        while (lo<=hi){
            int mid = lo+(hi-lo)/2;
            res = (x / res + res) / 2.0;
            if(res*res>x){
                hi = mid -1;
            }else if(res*res<x) {
                lo = mid+1;
            }else {
                break;
            }
        }
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(new MySqrt().mySqrt(8));
    }
}
