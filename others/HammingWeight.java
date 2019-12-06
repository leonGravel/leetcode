package others;

/**
 * @ClassName HammingWeight
 * @Description: 计算一个数字转为二进制后，1的个数
 * @Author gravel
 * @Date 2019/12/6
 * @Version V1.0
 *
 * 思路：
 * 将当前数字n，与n-1按位与.
 * 假设 n 的二进制为 1110
 * 那么每一次循环的值为：
 * 第一次
 * n   = 1110
 * n-1 = 1101
 * n&(n-1) = 1100
 *
 * 可以发现，n-1会将n最右边的1以及1右边的0全部取反
 * 然后n&(n-1)就相当于去掉了n最右边的1
 * 所以，最后n等于0；
 * 进行了多少次这样的运算，就是n中有多少个1。
 **/
public class HammingWeight {
    public int hammingWeight(int n) {
        int count = 0;
        while(n!=0){
            ++count;
            n &=n-1;
        }
        return count;
    }
}
