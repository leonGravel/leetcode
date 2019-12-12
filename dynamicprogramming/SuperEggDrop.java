package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName SuperEggDrop
 * @Description: 高楼扔鸡蛋
 * @Author gravel
 * @Date 2019/12/10
 * @Version V1.0
 * <p>
 * 思路：
 * 动态规划经典解题思路，状态推倒
 * 在i层扔鸡蛋，都有两种状态 1、鸡蛋碎,k-1。2、鸡蛋没碎 k不变
 * 可以得出 结果方程为 result = min(reault, max(dp(k-1,i-1),dp(k,n-i))+1)
 * dp(k-1,i-1) 代表，在i 层，鸡蛋碎了，然后他剩余搜索层数为i-1,鸡蛋数量减1
 * dp(k,n-i) 代表，在i层，鸡蛋没碎，然后他剩余搜索的层数为n-i,鸡蛋数量不变
 * 可以得出
 * 伪代码
 * func dp(){
 * int res = MAX_INT;
 * for(int i=0;i<=n;i++){
 * res = min(reault, max(dp(k-1,i-1),dp(k,n-i))+1)
 * }
 * return res;
 * }
 * 可以用二分查找代替这个for循环
 * 因为dp(k-1,i-1)，肯定是随着i的增加，而递增的，dp(k,n-i)则是线性递减，我们只需要找到中间他们相等的状态
 **/
public class SuperEggDrop {
    public int superEggDrop(int K, int N) {
        // 存储已经算过的结果
        Map<String, Integer> map = new HashMap<>(K * N * 2);
        return dp(K, N, map);
    }

    private int dp(int k, int n, Map<String, Integer> map) {
        // 如果只有零层楼，或者只有一个鸡蛋，那么就采用线性规划的最大值 n
        if (n == 0 || k == 1) {
            return n;
        }
        String key = k + "-" + n;
        // 避免重复
        if (map.get(key) != null) {
            return map.get(key);
        }
        int res = Integer.MAX_VALUE;
//        for(int i=1;i<=n;i++){
//            res = Math.min(res,Math.max(dp(k,n-i,map),dp(k-1,i-1,map))+1);
//        }
        int lo = 1;
        int hi = n;
        while (lo <= hi) {
            int mid = (lo + hi) >> 1;
            int broken = dp(k - 1, mid - 1, map);
            int notBroken = dp(k, n - mid, map);
            if (broken > notBroken) {
                hi = mid - 1;
                res = Math.min(res, broken + 1);
            } else {
                lo = mid + 1;
                res = Math.min(res, notBroken + 1);
            }
        }
        map.put(key, res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new SuperEggDrop().superEggDrop(4, 5000));
    }
}
